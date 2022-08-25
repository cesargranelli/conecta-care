package com.sevenine.conecta.usecase.impl;

//import net.sf.jasperreports.engine.JRException;
import static java.util.Objects.isNull;

import com.sevenine.conecta.converter.atendimento.ConsultaAtendimentoPreviewConverter;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.repository.AtendimentoCampoBaixaRepository;
import com.sevenine.conecta.repository.CampoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.repository.data.AtendimentoCampoBaixa;
import com.sevenine.conecta.repository.data.Campo;
import com.sevenine.conecta.services.ConsultaListaAtendimentoService;
import com.sevenine.conecta.services.ConsultaListaHomeCareService;
import com.sevenine.conecta.services.ConsultaListaPacienteService;
import com.sevenine.conecta.services.ConsultaListaProfissionalService;
import com.sevenine.conecta.services.data.report.AtendimentoPreviewReport;
import com.sevenine.conecta.services.data.request.atendimento.AtendimentoPreviewPara;
import com.sevenine.conecta.services.data.response.AtendimentoPreviewResponse;
import com.sevenine.conecta.services.data.response.AtendimentoProfissionalResponse;
import com.sevenine.conecta.services.data.response.AtendimentoSituacaoResponse;
import com.sevenine.conecta.services.data.response.PacienteResponse;
import com.sevenine.conecta.services.data.response.ProfissionalAtendimentoResponse;
import com.sevenine.conecta.services.data.response.StatusAtendimentoResponse;
import com.sevenine.conecta.usecase.ConsultaAtendimentoPorProfissionalUseCase;
import com.sevenine.conecta.usecase.ConsultaListaAtendimentoPreviewUseCase;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RequiredArgsConstructor
@Component
public class ConsultaListaAtendimentoPreviewUseCaseImpl implements ConsultaListaAtendimentoPreviewUseCase {

    private static final String CSV_SEPARATOR = ";";
    private static final String CSV_NEW_LINE = "\n";
    
    private final ConsultaAtendimentoPreviewConverter converter;

    private final ConsultaListaAtendimentoService consultaListaAtendimentoService;
    private final ConsultaListaPacienteService consultaListaPacienteService;
    private final ConsultaListaProfissionalService consultaListaProfissionalService;
    private final ConsultaListaHomeCareService consultaListaHomeCareService;
    
    private final ConsultaAtendimentoPorProfissionalUseCase consultaAtendimentoPorProfissionalUseCase;
    //private final ConsultaListaHomeCareService consultaListaHomeCareService;
    private final AtendimentoCampoBaixaRepository atendimentoCampoBaixaRepository;
    private final CampoRepository campoRepository;
    
    @Override
    public List<AtendimentoPreviewResponse> consultar(String cpfProfissional, String cpfPaciente, String areaAtendimentoId,
            String statusAtendimentoId, String homeCareId, LocalDate periodoDe,  LocalDate periodoAte) {
        
        HashMap<String, LocalDate> periodoConsultaMap = new HashMap<>();
        periodoConsultaMap.put("dataInicio", periodoDe);
        periodoConsultaMap.put("dataFim", periodoAte);
        List<Atendimento> atendimentos = consultaListaAtendimentoService.consultarPorHomeCarePeriodo(Long.parseLong(homeCareId), periodoConsultaMap);

        List<Long> profissionalIdList = atendimentos.stream().map(Atendimento::getProfissionalId).collect(Collectors.toList());
        List<AtendimentoProfissionalResponse> profissionais = consultaListaProfissionalService.consultar(profissionalIdList);

        List<Long> pacienteIdList = atendimentos.stream().map(Atendimento::getPacienteId).collect(Collectors.toList());
        List<PacienteResponse> pacientes = consultaListaPacienteService.consultar(pacienteIdList);

        //List<HomeCareResponse> homeCares = consultaListaHomeCareService.consultar();
        
        List<AtendimentoPreviewResponse>  atendimentosPreviewResponse = converter.fromListAtendimento(atendimentos, pacientes, profissionais);
        atendimentosPreviewResponse = atendimentosPreviewResponse.stream()
            .filter(atendimentoPreviewResponseFilter ->
                atendimentoPreviewResponseFilter.equalsProfissional(cpfProfissional) &&
                atendimentoPreviewResponseFilter.equalsPaciente(cpfPaciente) &&
                atendimentoPreviewResponseFilter.equalsAtendimento(areaAtendimentoId) &&
                atendimentoPreviewResponseFilter.equalsStatus(statusAtendimentoId)
            )
            .collect(Collectors.toList());

        return atendimentosPreviewResponse;
    }

    @Override
    public File consultarFile(AtendimentoPreviewPara gerarPara, String cpfProfissional, String cpfPaciente, String areaAtendimentoId, String statusAtendimentoId,
            String homeCareId, LocalDate periodoDe, LocalDate periodoAte) {

        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatterDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        List<AtendimentoPreviewResponse> atendimentosPreviewResponse = this.consultar(cpfProfissional, cpfPaciente, areaAtendimentoId, statusAtendimentoId, homeCareId, periodoDe, periodoAte);
        List<AtendimentoPreviewReport> atendimentosPreviewReport = new ArrayList<AtendimentoPreviewReport>();
        List<ProfissionalAtendimentoResponse> profissionaisAtendimentoResponse = new ArrayList<ProfissionalAtendimentoResponse>();
        
        //Iteirar sobre os profissionals
        Set<Long> profissionalIdList = atendimentosPreviewResponse.stream().map(AtendimentoPreviewResponse::getProfissionalId).collect(Collectors.toSet());
        profissionalIdList.forEach(profissionalId -> {
            try {
                List<ProfissionalAtendimentoResponse> pAR = consultaAtendimentoPorProfissionalUseCase.executarPorPeriodo(profissionalId, periodoDe, periodoAte);
                profissionaisAtendimentoResponse.addAll(pAR);
            }catch (NaoLocalizadoException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        });
        
        //
        profissionaisAtendimentoResponse.forEach(
            profissionalAtendimentoResponse -> {
                
                File assinaturaPaciente = Base64ToFile(profissionalAtendimentoResponse.getId(), profissionalAtendimentoResponse.getAssinatura());
                File assinaturaProfissional = Base64ToFile(profissionalAtendimentoResponse.getProfissional().getId(), profissionalAtendimentoResponse.getProfissional().getFotoAssinatura());
                
                profissionalAtendimentoResponse.getGrupos().stream().forEach(
                    grupoResponse -> {
                        grupoResponse.getSubgrupos().forEach(
                            subGrupoResponse -> {
                                subGrupoResponse.getCampos().forEach(
                                    campoResponse -> {

                                        StatusAtendimentoResponse statusAtendimentoResponse = profissionalAtendimentoResponse.statusRecente();
                                        String status = statusAtendimentoResponse != null 
                                                ? statusAtendimentoResponse.getDescricao()
                                                : "N�O DEFINIDO";
                                        
                                        
                                        String dataHora = profissionalAtendimentoResponse.getData().format(formatterData) + 
                                                profissionalAtendimentoResponse.getHora().format(formatterHora);
                                        
                                        AtendimentoSituacaoResponse atendimentoSituacaoResponseCheckIn = 
                                                profissionalAtendimentoResponse.getSituacoes()
                                                .stream().filter(atendimentoSituacaoResponseFilter -> atendimentoSituacaoResponseFilter.getStatus().getDescricao().contains("CHECK_IN"))
                                                .findAny().orElse(null);
                                        String checkIn = "";
                                        if (!isNull(atendimentoSituacaoResponseCheckIn)) {
                                            checkIn = atendimentoSituacaoResponseCheckIn.getDataHora().format(formatterDataHora);
                                        }
                                        
                                        AtendimentoSituacaoResponse atendimentoSituacaoResponseCheckOut = 
                                                profissionalAtendimentoResponse.getSituacoes()
                                                .stream().filter(atendimentoSituacaoResponseFilter -> atendimentoSituacaoResponseFilter.getStatus().getDescricao().contains("CHECK_OUT"))
                                                .findAny().orElse(null);
                                        
                                        String checkOut = "";
                                        if (!isNull(atendimentoSituacaoResponseCheckOut)) {
                                            checkOut = atendimentoSituacaoResponseCheckOut.getDataHora().format(formatterDataHora);
                                        }
                                        String profissionalArea = profissionalAtendimentoResponse.getProfissional().getEspecialidades() != null && profissionalAtendimentoResponse.getProfissional().getEspecialidades().size() > 0 
                                                ? profissionalAtendimentoResponse.getProfissional().getEspecialidades().get(0).getNome()
                                                : "";

                                        String profissionalContato = profissionalAtendimentoResponse.getProfissional().getContato() != null 
                                                ? profissionalAtendimentoResponse.getProfissional().getContato().getTelefoneCelular()
                                                : "";
                                        
                                        String campoBaixa = "";
                                        AtendimentoCampoBaixa atendimentoCampoBaixa = atendimentoCampoBaixaRepository.findByAtendimentoIdAndCampoId(profissionalAtendimentoResponse.getId(), campoResponse.getId()).orElse(null);
                                        if (atendimentoCampoBaixa != null && atendimentoCampoBaixa.getCampoId() > 0) {
                                            Campo campo = campoRepository.findById(atendimentoCampoBaixa.getCampoId()).orElse(null);
                                            if (campo != null) {
                                                if(campo.getTipo() != null && campo.getTipo().equals("checkbox")) {
                                                    campoBaixa = atendimentoCampoBaixa.getTexto() != null && atendimentoCampoBaixa.getTexto().equals("true") ? "X" : "";
                                                } else {
                                                    campoBaixa = atendimentoCampoBaixa.getTexto();
                                                }
                                            }
                                        }
                                        campoResponse.setCampoBaixa(campoBaixa);
                                        
                                        String enderecoId =  "";
                                        String enderecoCep =  "";
                                        String enderecoLogradouro =  "";
                                        String enderecoNumero =  "";
                                        String enderecoComplemento =  "";
                                        if (profissionalAtendimentoResponse.getEndereco() != null) {
                                            enderecoId =  profissionalAtendimentoResponse.getEndereco().getId().toString();
                                            enderecoCep =  profissionalAtendimentoResponse.getEndereco().getCep();
                                            enderecoLogradouro =  profissionalAtendimentoResponse.getEndereco().getLogradouro();
                                            enderecoNumero =  profissionalAtendimentoResponse.getEndereco().getNumero();
                                            enderecoComplemento =  profissionalAtendimentoResponse.getEndereco().getComplemento();

                                        }

                                        String homeCareNome = "";
                                        String tratamentoId = "";
                                        String tratamentoNome = "";

                                        BigDecimal atendmentoValorHC = BigDecimal.ZERO;
                                        BigDecimal atendmentoValorProf = BigDecimal.ZERO;
                                        BigDecimal atendmentoValorPac = BigDecimal.ZERO;
                                        BigDecimal atendmentoValorCusto = BigDecimal.ZERO;
                                        
                                        AtendimentoPreviewResponse atendimentoPreviewResponse = 
                                                atendimentosPreviewResponse.stream()
                                                .filter(atendimentoPreviewResponseFilter -> atendimentoPreviewResponseFilter.getId().equals(profissionalAtendimentoResponse.getId()))
                                                .findFirst().orElse(null);
                                        if(atendimentoPreviewResponse != null) {
                                            homeCareNome = atendimentoPreviewResponse.getHomeCareNome();
                                            tratamentoId = atendimentoPreviewResponse.getTipoAtendimentoId();
                                            tratamentoNome = atendimentoPreviewResponse.getTipoAtendimentoNome();

                                            atendmentoValorHC = atendimentoPreviewResponse.getValorHomeCare();
                                            atendmentoValorProf = atendimentoPreviewResponse.getValorProfissional();
                                            atendmentoValorPac = atendimentoPreviewResponse.getValorPaciente();
                                            atendmentoValorCusto = atendimentoPreviewResponse.getValorAjudaCusto();
                                        }
                                        
                                        AtendimentoPreviewReport atendimentoPreviewReport = AtendimentoPreviewReport.builder()
                                                .atendimentoId(profissionalAtendimentoResponse.getId())
                                                .atendimentoTipo(profissionalAtendimentoResponse.getTipo())
                                                .pacienteId(profissionalAtendimentoResponse.getPaciente().getId())
                                                .pacienteNome(profissionalAtendimentoResponse.getPaciente().getNome())
                                                .pacienteCpf(profissionalAtendimentoResponse.getPaciente().getCpf())
                                                .dataHora(dataHora)
                                                .status(status)
                                                .observacao(profissionalAtendimentoResponse.getObservacao() == null ? "" : profissionalAtendimentoResponse.getObservacao())
                                                .observacoesBaixa(profissionalAtendimentoResponse.getObservacoesBaixa() == null ? "" : profissionalAtendimentoResponse.getObservacoesBaixa())
                                                .protocolo(profissionalAtendimentoResponse.getProtocolo())
                                                .checkIn(checkIn)
                                                .checkOut(checkOut)
                                                .profissionalArea(profissionalArea)
                                                .profissionalNome(profissionalAtendimentoResponse.getProfissional().getNome())
                                                .profissionalContato(profissionalContato)
                                                .profissionalCpf(profissionalAtendimentoResponse.getProfissional().getCpf())
                                                .grupoId(grupoResponse.getId())
                                                .grupoNome(grupoResponse.getDescricao())
                                                .subGrupoId(subGrupoResponse.getId())
                                                .subGrupoNome(subGrupoResponse.getDescricao())
                                                .campoId(campoResponse.getId())
                                                .campoTipo(campoResponse.getTipo())
                                                .campoPre(campoResponse.getPre() == null ? "" : campoResponse.getPre())
                                                .campoPos(campoResponse.getPos() == null ? "" : campoResponse.getPos())
                                                .campoBaixa(campoBaixa == null ? "" : campoBaixa)
                                                .assinaturaPacientePath(assinaturaPaciente == null ? "" : assinaturaPaciente.getAbsolutePath())
                                                .assinaturaProfissionalPath(assinaturaProfissional == null ? "" : assinaturaProfissional.getAbsolutePath())
                                                .homeCareId(homeCareId)
                                                .homeCareNome(homeCareNome)
                                                .tratamentoId(tratamentoId)
                                                .tratamentoNome(tratamentoNome)
                                                .enderecoId(enderecoId)
                                                .enderecoCep(enderecoCep)
                                                .enderecoLogradouro(enderecoLogradouro)
                                                .enderecoNumero(enderecoNumero)
                                                .enderecoComplemento(enderecoComplemento)
                                                .atendmentoValorHC(atendmentoValorHC)
                                                .atendmentoValorProf(atendmentoValorProf)
                                                .atendmentoValorPac(atendmentoValorPac)
                                                .atendmentoValorCusto(atendmentoValorCusto)
                                                .build();
                                        atendimentosPreviewReport.add(atendimentoPreviewReport);

                                    });
                            });
                    });
            });
        
        try {
            switch (gerarPara) {
            case JSON:
                return extractedGerarJson(profissionaisAtendimentoResponse);

            case PDF:
                return extractedGerarPdf(cpfProfissional, cpfPaciente, areaAtendimentoId, statusAtendimentoId, homeCareId, periodoDe,
                        periodoAte, formatterData, atendimentosPreviewReport);
            case XML:
                return extractedGerarXml(profissionaisAtendimentoResponse);
            
            case XLSX:
                return extractedGerarXlsx(atendimentosPreviewReport);
                
            case CSV:
                return extractedGerarCsv(atendimentosPreviewReport);
                
            default:
                return null;
            }

        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return null;
    }

    private File extractedGerarJson(List<ProfissionalAtendimentoResponse> profissionaisAtendimentoResponse) {
        
        if(!isNull(profissionaisAtendimentoResponse) && profissionaisAtendimentoResponse.size() > 0) {
            try {
                ObjectMapper ob = new ObjectMapper();
                ob.setDateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));
                ob.setSerializationInclusion(Include.NON_NULL);
                String json = ob.writeValueAsString(profissionaisAtendimentoResponse);

                File tempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), "");
                FileUtils.writeByteArrayToFile(tempFile, json.getBytes());
                return tempFile;
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }

    private File extractedGerarXml(List<ProfissionalAtendimentoResponse> profissionaisAtendimentoResponse) {
        
        if(!isNull(profissionaisAtendimentoResponse) && profissionaisAtendimentoResponse.size() > 0) {
            try {
                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));
                xmlMapper.setSerializationInclusion(Include.NON_NULL);
                String xml = xmlMapper.writeValueAsString(profissionaisAtendimentoResponse);

                File tempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), "");
                FileUtils.writeByteArrayToFile(tempFile, xml.getBytes());
                return tempFile;
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
    
    private File extractedGerarPdf(String cpfProfissional, String cpfPaciente, String areaAtendimentoId,
            String statusAtendimentoId, String homeCareId, LocalDate periodoDe, LocalDate periodoAte,
            DateTimeFormatter formatterData, List<AtendimentoPreviewReport> atendimentosPreviewReport) throws JRException {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cpfProfissional", cpfProfissional);
        parameters.put("cpfPaciente", cpfPaciente);
        parameters.put("areaAtendimentoId", areaAtendimentoId);
        parameters.put("statusAtendimentoId", statusAtendimentoId);
        parameters.put("homeCareId", homeCareId);
        parameters.put("periodoDe", periodoDe.format(formatterData));
        parameters.put("periodoAte", periodoAte.format(formatterData));
        
        InputStream employeeReportStream
            = getClass().getResourceAsStream("/relatorios/preview.jrxml");
        JasperReport jasperReport
            = JasperCompileManager.compileReport(employeeReportStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport, parameters, new JRBeanCollectionDataSource(atendimentosPreviewReport));
    
    
        //String fileName = "C:/Temp/preview.pdf";
        String fileName = "preview-" + System.currentTimeMillis() + ".pdf";                
        JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);
        File file = new File(fileName);
        return file;
            
    }

    private File extractedGerarXlsx(List<AtendimentoPreviewReport> atendimentosPreviewReport) throws IOException {

        Workbook workbook = new XSSFWorkbook();
        try {
            Sheet sheet = workbook.createSheet("Persons");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 4000);
            
            Row header = sheet.createRow(0);
            CellStyle headerStyle = workbook.createCellStyle();
            
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            font.setBold(true);
            headerStyle.setFont(font);
            
            Cell headerCell = header.createCell(0);
            headerCell.setCellValue("atendimentoId");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(1);
            headerCell.setCellValue("pacienteId");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(2);
            headerCell.setCellValue("pacienteNome");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(3);
            headerCell.setCellValue("pacienteCpf");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(4);
            headerCell.setCellValue("dataHora");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(5);
            headerCell.setCellValue("status");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(6);
            headerCell.setCellValue("observacao");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(7);
            headerCell.setCellValue("observacoesBaixa");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(8);
            headerCell.setCellValue("protocolo");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(9);
            headerCell.setCellValue("checkIn");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(10);
            headerCell.setCellValue("checkOut");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(11);
            headerCell.setCellValue("profissionalArea");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(12);
            headerCell.setCellValue("profissionalNome");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(13);
            headerCell.setCellValue("profissionalContato");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(14);
            headerCell.setCellValue("grupoId");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(15);
            headerCell.setCellValue("grupoNome");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(16);
            headerCell.setCellValue("subGrupoId");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(17);
            headerCell.setCellValue("subGrupoNome");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(18);
            headerCell.setCellValue("campoId");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(19);
            headerCell.setCellValue("campoTipo");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(20);
            headerCell.setCellValue("campoPre");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(21);
            headerCell.setCellValue("campoPos");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(22);
            headerCell.setCellValue("campoBaixa");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(23);
            headerCell.setCellValue("homeCareId");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(24);
            headerCell.setCellValue("homeCareNome");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(25);
            headerCell.setCellValue("tratamentoId");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(26);
            headerCell.setCellValue("tratamentoNome");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(27);
            headerCell.setCellValue("enderecoId");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(28);
            headerCell.setCellValue("enderecoCep");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(29);
            headerCell.setCellValue("enderecoLogradouro");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(30);
            headerCell.setCellValue("enderecoNumero");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(31);
            headerCell.setCellValue("enderecoComplemento");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(32);
            headerCell.setCellValue("atendmentoValorHC");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(33);
            headerCell.setCellValue("atendmentoValorProf");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(34);
            headerCell.setCellValue("atendmentoValorPac");
            headerCell.setCellStyle(headerStyle);
    
            headerCell = header.createCell(35);
            headerCell.setCellValue("atendmentoValorCusto");        
            headerCell.setCellStyle(headerStyle);
    
            Integer linha = 1;
            CellStyle style = workbook.createCellStyle();        
            for (AtendimentoPreviewReport atendimentoPreviewReport: atendimentosPreviewReport) {
                
                Row row = sheet.createRow(linha);
    
                Cell cell = row.createCell(0);            
                cell.setCellValue(atendimentoPreviewReport.getAtendimentoId());
                
                cell = row.createCell(1);            
                cell.setCellValue(atendimentoPreviewReport.getPacienteId());
                
                cell = row.createCell(2);            
                cell.setCellValue(atendimentoPreviewReport.getPacienteNome());
                
                cell = row.createCell(3);            
                cell.setCellValue(atendimentoPreviewReport.getPacienteCpf());
                
                cell = row.createCell(4);            
                cell.setCellValue(atendimentoPreviewReport.getDataHora());
                
                cell = row.createCell(5);            
                cell.setCellValue(atendimentoPreviewReport.getStatus());
                
                cell = row.createCell(6);            
                cell.setCellValue(atendimentoPreviewReport.getObservacao());
                
                cell = row.createCell(7);            
                cell.setCellValue(atendimentoPreviewReport.getObservacoesBaixa());
                
                cell = row.createCell(8);            
                cell.setCellValue(atendimentoPreviewReport.getProtocolo());
                
                cell = row.createCell(9);            
                cell.setCellValue(atendimentoPreviewReport.getCheckIn());
                
                cell = row.createCell(10);            
                cell.setCellValue(atendimentoPreviewReport.getCheckOut());
                
                cell = row.createCell(11);            
                cell.setCellValue(atendimentoPreviewReport.getProfissionalArea());
                
                cell = row.createCell(12);            
                cell.setCellValue(atendimentoPreviewReport.getProfissionalNome());
                
                cell = row.createCell(13);            
                cell.setCellValue(atendimentoPreviewReport.getProfissionalContato());
                
                cell = row.createCell(14);            
                cell.setCellValue(atendimentoPreviewReport.getGrupoId());
                
                cell = row.createCell(15);            
                cell.setCellValue(atendimentoPreviewReport.getGrupoNome());
                
                cell = row.createCell(16);            
                cell.setCellValue(atendimentoPreviewReport.getSubGrupoId());
                
                cell = row.createCell(17);            
                cell.setCellValue(atendimentoPreviewReport.getSubGrupoNome());
                
                cell = row.createCell(18);            
                cell.setCellValue(atendimentoPreviewReport.getCampoId());
                
                cell = row.createCell(19);            
                cell.setCellValue(atendimentoPreviewReport.getCampoTipo());
                
                cell = row.createCell(20);            
                cell.setCellValue(atendimentoPreviewReport.getCampoPre());
                
                cell = row.createCell(21);            
                cell.setCellValue(atendimentoPreviewReport.getCampoPos());
                
                cell = row.createCell(22);            
                cell.setCellValue(atendimentoPreviewReport.getCampoBaixa());
                
                cell = row.createCell(23);            
                cell.setCellValue(atendimentoPreviewReport.getHomeCareId());
                
                cell = row.createCell(24);            
                cell.setCellValue(atendimentoPreviewReport.getHomeCareNome());
                
                cell = row.createCell(25);            
                cell.setCellValue(atendimentoPreviewReport.getTratamentoId());
                
                cell = row.createCell(26);            
                cell.setCellValue(atendimentoPreviewReport.getTratamentoNome());
                
                cell = row.createCell(27);            
                cell.setCellValue(atendimentoPreviewReport.getEnderecoId());
                
                cell = row.createCell(28);            
                cell.setCellValue(atendimentoPreviewReport.getEnderecoCep());
                
                cell = row.createCell(29);            
                cell.setCellValue(atendimentoPreviewReport.getEnderecoLogradouro());
                
                cell = row.createCell(30);            
                cell.setCellValue(atendimentoPreviewReport.getEnderecoNumero());
                
                cell = row.createCell(31);            
                cell.setCellValue(atendimentoPreviewReport.getEnderecoComplemento());
                
                cell = row.createCell(32);            
                cell.setCellValue(atendimentoPreviewReport.getAtendmentoValorHC().doubleValue());
                
                cell = row.createCell(33);
                cell.setCellValue(atendimentoPreviewReport.getAtendmentoValorProf().doubleValue());
                
                cell = row.createCell(34);            
                cell.setCellValue(atendimentoPreviewReport.getAtendmentoValorPac().doubleValue());
                
                cell = row.createCell(35);            
                cell.setCellValue(atendimentoPreviewReport.getAtendmentoValorCusto().doubleValue());
                
                linha++;
            }
            
            File outputFile = new File("preview-" + System.currentTimeMillis() + ".xlsx");
            //String path = outputFile.getAbsolutePath();
            //String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";
    
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            workbook.write(outputStream);
            
            return outputFile;
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }           
    }

    private File extractedGerarCsv(List<AtendimentoPreviewReport> atendimentosPreviewReport) throws JRException, IOException {

        if(!isNull(atendimentosPreviewReport) && atendimentosPreviewReport.size() > 0) {
            try {
                File tempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), "");
                StringBuffer oneLine = new StringBuffer();
                oneLine.append("atendimentoId;pacienteId;pacienteNome;pacienteCpf;dataHora;status;observacao;observacoesBaixa;protocolo;checkIn;checkOut;profissionalArea;profissionalNome;profissionalContato;grupoId;grupoNome;subGrupoId;subGrupoNome;campoId;campoTipo;campoPre;campoPos;campoBaixa;homeCareId;homeCareNome;tratamentoId;tratamentoNome;enderecoId;enderecoCep;enderecoLogradouro;enderecoNumero;enderecoComplemento;atendmentoValorHC;atendmentoValorProf;atendmentoValorPac;atendmentoValorCusto\n");
                for (AtendimentoPreviewReport atendimentoPreviewReport: atendimentosPreviewReport) {
                    oneLine.append(
                        atendimentoPreviewReport.getAtendimentoId() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getPacienteId() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getPacienteNome() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getPacienteCpf() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getDataHora() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getStatus() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getObservacao() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getObservacoesBaixa() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getProtocolo() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getCheckIn() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getCheckOut() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getProfissionalArea() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getProfissionalNome() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getProfissionalContato() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getGrupoId() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getGrupoNome() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getSubGrupoId() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getSubGrupoNome() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getCampoId() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getCampoTipo() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getCampoPre() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getCampoPos() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getCampoBaixa() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getHomeCareId() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getHomeCareNome() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getTratamentoId() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getTratamentoNome() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getEnderecoId() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getEnderecoCep() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getEnderecoLogradouro() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getEnderecoNumero() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getEnderecoComplemento() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getAtendmentoValorHC() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getAtendmentoValorProf() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getAtendmentoValorPac() + CSV_SEPARATOR +
                        atendimentoPreviewReport.getAtendmentoValorCusto() + CSV_SEPARATOR +
                        CSV_NEW_LINE);
                }
                
                FileUtils.writeByteArrayToFile(tempFile, oneLine.toString().getBytes());
                return tempFile;
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return null;
        
    }
    
    private File Base64ToFile(Long atendimentoId, String assinatura) {

        if(!isNull(atendimentoId) && !isNull(assinatura) && StringUtils.isNotBlank(assinatura)) {
            try {
                assinatura = assinatura
                        .replace("data:image/jpeg;base64,", "")
                        .replace("data:image/jpg;base64,", "")
                        .replace("data:image/png;base64,", "");
                byte[] image = Base64.getDecoder().decode(assinatura);
                File tempFile = File.createTempFile(String.valueOf(atendimentoId), "");
                FileUtils.writeByteArrayToFile(tempFile, image);
                return tempFile;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        
        return null;
    }
}
