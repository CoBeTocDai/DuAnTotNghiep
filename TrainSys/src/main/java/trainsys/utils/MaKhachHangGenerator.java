/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.utils;

/**
 *
 * @author ADMIN
 */
public class MaKhachHangGenerator {
    private static int dem = 1;

    public static String taoMaKH() {
        return "KH" + String.format("%03d", dem++);
    }
}
