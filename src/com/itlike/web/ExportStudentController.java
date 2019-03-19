package com.itlike.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

import com.itlike.domain.Student;
import com.itlike.service.StatisticsService;
import javafx.geometry.Pos;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ExportStudentController {
	@Autowired
	private StatisticsService statisticsService;

	@RequestMapping(value = "exportFile")
	public void statisticsNumbers(HttpServletResponse response) {

	    Workbook wbss = new XSSFWorkbook();
		List<Student> allStudent = statisticsService.getAllStudent();
		for (Student student : allStudent) {
			System.out.println(student);
		}
		exportByClass(allStudent,"学生信息",wbss);

		exportFile("学生信息.xlsx",wbss,response);
	}
	
	private static void exportByClass(List<Student> list,String className,Workbook wbss){
		Sheet ss1 = wbss.createSheet(className); 
	    Row rowxl = ss1.createRow((int)0);

    	rowxl.createCell(0).setCellValue("姓名");
		rowxl.createCell(1).setCellValue("性别");
		rowxl.createCell(2).setCellValue("名族");
		rowxl.createCell(3).setCellValue("考生编号");
		rowxl.createCell(4).setCellValue("身份证号");
		rowxl.createCell(5).setCellValue("本科毕业院校");
		rowxl.createCell(6).setCellValue("本科毕业专业");
		rowxl.createCell(7).setCellValue("联系电话");
		rowxl.createCell(8).setCellValue("邮箱");
		rowxl.createCell(9).setCellValue("一志愿报考单位名称");
		rowxl.createCell(10).setCellValue("一志愿报考专业代码");
		rowxl.createCell(11).setCellValue("一志愿报考专业名称");
		rowxl.createCell(12).setCellValue("总分");
		rowxl.createCell(13).setCellValue("政治");
		rowxl.createCell(14).setCellValue("英语");
		rowxl.createCell(15).setCellValue("专业课1名称");
		rowxl.createCell(16).setCellValue("专业课1分数");
		rowxl.createCell(17).setCellValue("专业课2名称");
		rowxl.createCell(18).setCellValue("专业课2分数");
		rowxl.createCell(19).setCellValue("调剂院系");
		rowxl.createCell(20).setCellValue("调剂专业");
		rowxl.createCell(21).setCellValue("获得调剂信息渠道");
		rowxl.createCell(22).setCellValue("是否为985/211（1为是,0为否）");

	    	if(list!=null&&list.size()>0){
	    	for(int i=0;i<list.size();i++){ 
	    		Row row = ss1.createRow((int)i+1); 	
	    		Student student=list.get(i);
	    		if(student!=null){
	    			row.createCell(0).setCellValue(student.getName());
					row.createCell(1).setCellValue(student.getSex());
					row.createCell(2).setCellValue(student.getNationality());
					row.createCell(3).setCellValue(student.getNumber());
					row.createCell(4).setCellValue(student.getId_card());
					row.createCell(5).setCellValue(student.getGraduated_college());
					row.createCell(6).setCellValue(student.getGraduated_major());
					row.createCell(7).setCellValue(student.getTelnumber());
					row.createCell(8).setCellValue(student.getEmail());
					row.createCell(9).setCellValue(student.getFirst_applicant_name());
					row.createCell(10).setCellValue(student.getFirst_major_code());
					row.createCell(11).setCellValue(student.getFirst_major_name());
					row.createCell(12).setCellValue(student.getTotal_score());
					row.createCell(13).setCellValue(student.getPolitical_score());


					row.createCell(14).setCellValue(student.getEnglish_score());
					row.createCell(15).setCellValue(student.getMajor_1_name());
					row.createCell(16).setCellValue(student.getMajor_1_score());
					row.createCell(17).setCellValue(student.getMajor_2_name());
					row.createCell(18).setCellValue(student.getMajor_2_score());
					row.createCell(19).setCellValue(student.getAdjustment_dep());
					row.createCell(20).setCellValue(student.getAdjustment_major());
					row.createCell(21).setCellValue(student.getAccess_information());
					row.createCell(22).setCellValue(student.getIs985_211());
	    		}
	    	}
    	}
	}
	

	private static void exportFile(String fileName, Workbook wbss, HttpServletResponse response){
		try {		
			response.setHeader("Content-disposition", "attachment; filename=\""
					+ new String(fileName.getBytes("GBK"), "ISO-8859-1")+"\"");

			OutputStream out = response.getOutputStream();
			//WritableByteChannel outChannel = Channels.newChannel(out);
			 wbss.write(out);
		
			out.flush();
			out.close();
	
		}catch (IOException ioe) {
			ioe.printStackTrace();
			output(response, "您所请求的文件出现异常！");
		} catch (Exception e) {
			e.printStackTrace();
			output(response, "您所请求的文件出现异常！");
		}	
	}
	
	private static void output(HttpServletResponse response, String message) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			Writer out = response.getWriter();
			out.write(message);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
