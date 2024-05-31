package com.example.demo.helpers.writer;

import com.example.demo.models.Employee;
import com.example.demo.models.Speciality;
import com.example.demo.services.SpecialityService;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.*;

public class ReadFileExcel {

    public static List<InputFile> readFile(Workbook workbook, List<Employee> employee, List<Speciality> specialities, Integer year) throws Exception {
//        // Создайте объект для чтения файла Excel
//        FileInputStream fis = new FileInputStream(new File(filePath));
//
//        // Создайте объект для рабочей книги (Workbook)
//        Workbook workbook = WorkbookFactory.create(fis);

        // Получите первый лист из книги
        Sheet sheet = workbook.getSheetAt(0);

        // Пройдите по всем строкам в листе
        return checkFile(sheet, employee, specialities);
    }

    private static List<InputFile> checkFile(Sheet sheet, List<Employee> employee, List<Speciality> specialities) throws Exception {
        int count = 0;
        List<InputFile> listValue = new ArrayList<InputFile>();
        for (Row row : sheet) {
            if (count > 0) {
                InputFile res = new InputFile();
                Cell cellDescr = row.getCell(1);
                if (row.getCell(0).getNumericCellValue() == 0.0) {
                    return listValue;
                }
                if (cellDescr.getCellType() == STRING || cellDescr.getCellType() == BLANK) {
                    res.setDescr(cellDescr.getStringCellValue());
                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 1.");
                }
                Cell cellSpeciality = row.getCell(2);
                if (cellSpeciality.getCellType() == STRING || cellSpeciality.getCellType() == BLANK) {
                    int id = findSpeciality(specialities, cellSpeciality.getStringCellValue());
                    if (id != -1) {
                        res.setIdSpeciality(id);
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 2.");
                    }
                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 2.");
                }
                Cell cellDepartment = row.getCell(3);
                if (cellDepartment.getCellType() == STRING || cellDepartment.getCellType() == BLANK) {
                    res.setDepartment(cellDepartment.getStringCellValue());
                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 3.");
                }
                Cell cellEmployee = row.getCell(4);
                if (cellEmployee != null) {
                    if (cellEmployee.getCellType() == STRING || cellEmployee.getCellType() == BLANK) {
                        Integer idEmployee = findEmployee(employee, cellEmployee.getStringCellValue());
                        if (idEmployee != -1) {
                            res.setEmployee(idEmployee);
                        } else {
                            throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 4...");
                        }

                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 4.");
                    }
                }
                Cell cellContract = row.getCell(5);
                if (cellContract != null) {
                    if (cellContract.getCellType() == STRING || cellContract.getCellType() == BLANK) {
                        if (cellContract.getStringCellValue().equals("+")) {
                            res.setContract(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 5.");
                    }
                }
                Cell cellStudent = row.getCell(6);
                if (cellStudent.getCellType() == NUMERIC || cellStudent.getCellType() == BLANK) {
                    res.setStudentCount((int) cellStudent.getNumericCellValue());
                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 6.");
                }

                Cell cellSubGroup = row.getCell(7);
                if (cellSubGroup.getCellType() == NUMERIC || cellSubGroup.getCellType() == BLANK) {
                    res.setSubGroupCount((int) cellSubGroup.getNumericCellValue());
                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 7.");
                }

                Cell cellSemester = row.getCell(8);
                if (cellSemester.getCellType() == NUMERIC || cellSemester.getCellType() == BLANK) {
                    int semester = (int) cellSemester.getNumericCellValue();
                    if (semester > 0 && semester < 13) {
                        res.setSemesterDescr(semester);
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 8.");
                    }

                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 8...");
                }
                Cell cellLecture = row.getCell(9);
                if (cellLecture != null) {
                    if (cellLecture.getCellType() == NUMERIC || cellLecture.getCellType() == BLANK) {
                        res.setLectureCount((int) cellLecture.getNumericCellValue());
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 9.");
                    }
                }
                Cell cellPractice = row.getCell(10);
                if (cellPractice != null) {
                    if (cellPractice.getCellType() == NUMERIC || cellPractice.getCellType() == BLANK) {
                        res.setPracticeCount((int) cellPractice.getNumericCellValue());
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 10.");
                    }
                }
                Cell cellLab = row.getCell(11);
                if (cellLab != null) {
                    if (cellLab.getCellType() == NUMERIC || cellLab.getCellType() == BLANK) {
                        res.setLabCount((int) cellLab.getNumericCellValue());
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 11.");
                    }
                }
                Cell cellKR = row.getCell(12);
                if (cellKR != null) {
                    if (cellKR.getCellType() == STRING || cellKR.getCellType() == BLANK) {
                        if (cellKR.getStringCellValue().equals("+")) {
                            res.setKR(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 12.");
                    }
                }
                Cell cellKP = row.getCell(13);
                if (cellKP != null) {
                    if (cellKP.getCellType() == STRING || cellKP.getCellType() == BLANK) {
                        if (cellKP.getStringCellValue().equals("+")) {
                            res.setKP(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 13.");
                    }
                }
                Cell cellEkz = row.getCell(14);
                if (cellEkz != null) {
                    if (cellEkz.getCellType() == STRING || cellEkz.getCellType() == BLANK) {
                        if (cellEkz.getStringCellValue().equals("+")) {
                            res.setEkz(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 14.");
                    }
                }
                Cell cellZach = row.getCell(15);
                if (cellZach != null) {
                    if (cellZach.getCellType() == STRING || cellZach.getCellType() == BLANK) {
                        if (cellZach.getStringCellValue().equals("+")) {
                            res.setZach(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 15.");
                    }
                }
                Cell cellKrR = row.getCell(16);
                if (cellKrR != null) {
                    if (cellKrR.getCellType() == STRING || cellKrR.getCellType() == BLANK) {
                        if (cellKrR.getStringCellValue().equals("+")) {
                            res.setKrR(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 16.");
                    }
                }
                Cell cellCons = row.getCell(17);
                if (cellCons != null) {
                    if (cellCons.getCellType() == STRING || cellCons.getCellType() == BLANK) {
                        if (cellCons.getStringCellValue().equals("+")) {
                            res.setCons(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 17.");
                    }
                }
                Cell ucPract = row.getCell(18);
                if (ucPract != null) {
                    if (ucPract.getCellType() == STRING || ucPract.getCellType() == BLANK) {
                        if (ucPract.getStringCellValue().equals("+")) {
                            res.setUcPract(1);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 18.");
                    }
                }
                Cell prPract = row.getCell(19);
                if (prPract != null) {
                    if (prPract.getCellType() == STRING || prPract.getCellType() == BLANK) {
                        if (prPract.getStringCellValue().equals("+")) {
                            res.setPrPract(1);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 19.");
                    }
                }

                Cell predPract = row.getCell(20);
                if (predPract != null) {
                    if (predPract.getCellType() == STRING || predPract.getCellType() == BLANK) {
                        if (predPract.getStringCellValue().equals("+")) {
                            res.setPredDPract(1);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 20.");
                    }
                }
                listValue.add(res);
            }
            count++;
        }
        return listValue;
    }


    private static Integer findEmployee(List<Employee> employees, String name) {
        for (Employee emp : employees) {
            if (emp.getEmployeeName() == name) {
                return emp.getId();
            }
            if (emp.getEmployeeName().contains(name)) {
                return emp.getId();
            }
        }
        return -1;
    }

    private static Integer findSpeciality(List<Speciality> specialities, String name) {
        for (Speciality sp : specialities) {
            if (sp.getDescr().contains(name) ||
                    sp.getDescr().replaceAll("\"", "").contains(name) ||
                    sp.getDescr().replaceAll(" ", "").contains(name.replaceAll(" ", "")) ||
                    sp.getDescr().replaceAll(" ", "").contains(name.replaceAll(" ", "")) ||
                    sp.getDescr().replaceAll(" ", "").contains(name.replaceAll("\"", ""))
            ) {
                return sp.getId();
            }
        }
        return -1;
    }

    private static InputFile readRow(Row row) {
        InputFile res = new InputFile();
        Cell cellDescr = row.getCell(0);
        if (cellDescr.getCellType() == STRING) {
            res.setDescr(cellDescr.getStringCellValue());
        }

        return res;
    }
}
