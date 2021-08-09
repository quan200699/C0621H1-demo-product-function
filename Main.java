package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        String[] products = new String[3];
        do {
            menu();
            System.out.println("Vui lòng nhập số từ 0->7:");
            choice = scanner.nextInt();
            switch (choice) {
                //1. Nhập các phần tử của mảng từ bàn phím
                case 1: {
                    scanner.nextLine();
                    products = inputProductArray(3, scanner);
                    break;
                }
                //2. Hiện thị danh sách các phần tử có trong mảng lên màn hình
                case 2: {
                    displayProducts(products);
                    break;
                }
                //3. Thêm phần tử vào mảng - thêm vào vị trí bất kỳ
                case 3: {
                    System.out.println("Nhập vị trí cần thêm giá trị mới:");
                    int indexAdd = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập giá trị cần thêm vào:");
                    String newProduct = scanner.nextLine();
                    products = addNewElementToArray(products, indexAdd, newProduct);
                    break;
                }
                //4. Xóa phần tử khỏi mảng
                case 4: {
                    System.out.println("Nhập vị trí cần xóa:");
                    int indexDelete = scanner.nextInt();
                    products = removeElementFromArray(products, indexDelete);
                    scanner.nextLine();
                    break;
                }
                //5. Xây dựng hàm tìm kiếm sản phẩm trong mảng
                case 5: {
                    System.out.println("Nhập tên sản phẩm cần tìm:");
                    String product = scanner.nextLine();
                    int index = findProductByName(products, product);
                    if (index == -1) {
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println("Tìm thấy sản phẩm " + product + " tại vị trí " + index);
                    }
                    break;
                }
                //6. Sắp xếp sản phẩm theo tên từ A->Z
                case 6: {
                    sortProductByName(products);
                    break;
                }
                //7. Cập nhật thông tin sản phẩm
                case 7: {
                    System.out.println("Nhập vị trí cần chỉnh sửa:");
                    int indexUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập giá trị cần cập nhật:");
                    String productUpdate = scanner.nextLine();
                    updateProductById(products, indexUpdate, productUpdate);
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("Menu");
        System.out.println("1. Nhập thông tin cho mảng sản phẩm");
        System.out.println("2. Hiển thị thông tin mảng");
        System.out.println("3. Thêm sản phẩm vào mảng");
        System.out.println("4. Xóa sản phẩm khỏi mảng");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Sắp xếp theo thứ tự A->Z");
        System.out.println("7. Cập nhật thông tin sản phẩm");
        System.out.println("0. Thoát");
    }

    public static void updateProductById(String[] products, int indexUpdate, String productUpdate) {
        products[indexUpdate] = productUpdate;
    }

    public static void sortProductByName(String[] products) {
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products.length; j++) {
                if (products[i].compareTo(products[j]) < 0) {
                    String temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
    }

    public static int findProductByName(String[] products, String product) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].equals(product)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static String[] removeElementFromArray(String[] products, int indexDelete) {
        String[] newProducts = new String[products.length - 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < indexDelete) {
                newProducts[i] = products[i];
            } else {
                newProducts[i] = products[i + 1];
            }
        }
        return newProducts;
    }

    public static String[] addNewElementToArray(String[] products, int indexAdd, String newProduct) {
        String[] newProducts = new String[products.length + 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < indexAdd) {
                newProducts[i] = products[i];
            } else if (i == indexAdd) {
                newProducts[i] = newProduct;
            } else {
                newProducts[i] = products[i - 1];
            }
        }
        return newProducts;
    }

    public static String[] inputProductArray(int size, Scanner scanner) {
        String[] products = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập tên của sản phẩm thứ " + (i + 1) + ":");
            products[i] = scanner.nextLine();
        }
        return products;
    }

    public static void displayProducts(String[] products) {
        for (String product : products) {
            System.out.printf("%s\t", product);
        }
        System.out.println();
    }
}
