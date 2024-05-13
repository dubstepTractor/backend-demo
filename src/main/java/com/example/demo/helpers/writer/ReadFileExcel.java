package com.example.demo.helpers.writer;

import com.example.demo.models.Employee;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.*;

public class ReadFileExcel {

    public static List<InputFile> readFile(String filePath, List<Employee> employee, Integer year) throws Exception {
        // Создайте объект для чтения файла Excel
        FileInputStream fis = new FileInputStream(new File(filePath));

        // Создайте объект для рабочей книги (Workbook)
        Workbook workbook = WorkbookFactory.create(fis);

        // Получите первый лист из книги
        Sheet sheet = workbook.getSheetAt(0);

        // Пройдите по всем строкам в листе
        return checkFile(sheet, employee);
    }

    private static List<InputFile> checkFile(Sheet sheet, List<Employee> employee) throws Exception {
        int count = 0;
        List<InputFile> listValue = new ArrayList<InputFile>();
        for (Row row : sheet) {
            if (count > 1) {
                InputFile res = new InputFile();
                Cell cellDescr = row.getCell(1);
                if (cellDescr.getCellType() == STRING) {
                    res.setDescr(cellDescr.getStringCellValue());
                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 1.");
                }
                Cell cellDepartment = row.getCell(2);
                if (cellDepartment.getCellType() == STRING) {
                    res.setDepartment(cellDepartment.getStringCellValue());
                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 2.");
                }
                Cell cellEmployee = row.getCell(3);
                if (cellEmployee != null) {
                    if (cellEmployee.getCellType() == STRING) {
                        Integer idEmployee = findEmployee(employee, cellEmployee.getStringCellValue());
                        if (idEmployee != -1) {
                            res.setEmployee(idEmployee);
                        } else {
                            throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 3...");
                        }

                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 3.");
                    }
                }
                Cell cellContract = row.getCell(4);
                if (cellContract != null) {
                    if (cellContract.getCellType() == STRING || cellContract.getCellType() == BLANK) {
                        if (cellContract.getStringCellValue().equals("+")) {
                            res.setContract(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 4.");
                    }
                }
                Cell cellStudent = row.getCell(5);
                if (cellStudent.getCellType() == NUMERIC) {
                    res.setStudentCount((int) cellStudent.getNumericCellValue());
                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 5.");
                }

                Cell cellSubGroup = row.getCell(6);
                if (cellSubGroup.getCellType() == NUMERIC) {
                    res.setSubGroupCount((int) cellSubGroup.getNumericCellValue());
                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 6.");
                }

                Cell cellSemester = row.getCell(7);
                if (cellSemester.getCellType() == NUMERIC) {
                    int semester = (int) cellSemester.getNumericCellValue();
                    if (semester > 0 && semester < 13) {
                        res.setSemesterDescr(semester);
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 7.");
                    }

                } else {
                    throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 7.");
                }
                Cell cellLecture = row.getCell(8);
                if (cellLecture != null) {
                    if (cellLecture.getCellType() == NUMERIC) {
                        res.setLectureCount((int) cellLecture.getNumericCellValue());
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 8.");
                    }
                }
                Cell cellPractice = row.getCell(9);
                if (cellPractice != null) {
                    if (cellPractice.getCellType() == NUMERIC || cellPractice.getCellType() == BLANK) {
                        res.setPracticeCount((int) cellPractice.getNumericCellValue());
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 9.");
                    }
                }
                Cell cellLab = row.getCell(10);
                if (cellLab != null) {
                    if (cellLab.getCellType() == NUMERIC || cellLab.getCellType() == BLANK) {
                        res.setLabCount((int) cellLab.getNumericCellValue());
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 10.");
                    }
                }
                Cell cellKR = row.getCell(11);
                if (cellKR != null) {
                    if (cellKR.getCellType() == STRING || cellKR.getCellType() == BLANK) {
                        if (cellKR.getStringCellValue().equals("+")) {
                            res.setKR(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 11.");
                    }
                }
                Cell cellKP = row.getCell(12);
                if (cellKP != null) {
                    if (cellKP.getCellType() == STRING || cellKP.getCellType() == BLANK) {
                        if (cellKP.getStringCellValue().equals("+")) {
                            res.setKP(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 12.");
                    }
                }
                Cell cellEkz = row.getCell(13);
                if (cellEkz != null) {
                    if (cellEkz.getCellType() == STRING || cellEkz.getCellType() == BLANK) {
                        if (cellEkz.getStringCellValue().equals("+")) {
                            res.setEkz(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 13.");
                    }
                }
                Cell cellZach = row.getCell(14);
                if (cellZach != null) {
                    if (cellZach.getCellType() == STRING || cellZach.getCellType() == BLANK) {
                        if (cellZach.getStringCellValue().equals("+")) {
                            res.setZach(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 14.");
                    }
                }
                Cell cellKrR = row.getCell(15);
                if (cellKrR != null) {
                    if (cellKrR.getCellType() == STRING || cellKrR.getCellType() == BLANK) {
                        if (cellKrR.getStringCellValue().equals("+")) {
                            res.setKrR(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 15.");
                    }
                }
                Cell cellCons = row.getCell(16);
                if (cellCons != null) {
                    if (cellCons.getCellType() == STRING || cellCons.getCellType() == BLANK) {
                        if (cellCons.getStringCellValue().equals("+")) {
                            res.setCons(true);
                        }
                    } else {
                        throw new Exception("Ошибка валидации. Проверьте файл на строке " + (count + 1) + ". В ячейке 16.");
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

    private static InputFile readRow(Row row) {
        InputFile res = new InputFile();
        Cell cellDescr = row.getCell(0);
        if (cellDescr.getCellType() == STRING) {
            res.setDescr(cellDescr.getStringCellValue());
        }

        return res;
    }
}
