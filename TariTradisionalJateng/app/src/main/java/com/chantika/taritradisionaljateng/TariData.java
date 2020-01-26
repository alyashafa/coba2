package com.chantika.taritradisionaljateng;

import java.util.ArrayList;

public class TariData {
        public static String[][]data = new String[][]{
                {"0","Tari Blambangan Cakil", "Tari Blambangan Cakil adalah tarian yang diadopsi dari cerita pewayangan. Adegan yang disadur sebagai tarian adalah “Perang Kembang” dimana para ksatria dan raksasa saling berperang, meggambarkan peperangan antara kebaikan melawan kejahatan.", "https://i.postimg.cc/BvvXMdxb/bambangan-cakil.jpg"},
                {"1","Tari Bedhaya Katawang", "Tari Bedhaya Katawang dipentaskan oleh 9 penari wanita saat peringatan dan penobatan tahta Kasunanan Surakarta. Bedhaya Katawang terdiri dari dua suku kata yakni kata Bedhaya yang memiliki makna penari wanita dan Ketawang yang memiliki makna langit, langit mengandung kiasan untuk sesuatu yang mulia, luhur dan tinggi.", "https://i.postimg.cc/L6p4ynfh/bedhaya-ketawang-2-780x405.jpg"},
                {"2","Tari Lengger", "Tari Lengger merupakan tarian daerah Jawa Tengah dari Wonosobo. Tari tradisional ini telah lebih dari satu abad diperkenalkan. Pertama kali dirintis 1910 di Dusun Giyanti oleh tokoh kesenian dari Desa Kecis, Selomerto, yakni Gondhowinangun.", "https://i.postimg.cc/FzQfgGNH/lengger.jpg"},
                {"3","Tari Ronggeng", "Tari Ronggeng telah berkembang di masyarakat Jawa Barat dan Jawa Tengah kemungkinan dari zaman kuno, relief di bagian Karmawibhanga pada abad ke-8 Borobudur menampilkan adegan perjalanan rombongan hiburan dengan musisi dan penari wanita.", "https://i.postimg.cc/6QkVgrtD/Ronggeng-800x480.jpg"},
                {"4","Tari Bondan", "Tari Bondan berasal dari daerah Surakarta, Jawa Tengah. Tarian Ini memperlihatkan gambaran kasih tulus ibu pada anaknya. Ciri khas yang dapat dilihat dan dibedakan dari tarian lainnya adalah pada properti yang dipakai dalam pementasan tari seperti kendil, boneka bayi, payung dan beberapa alat rumah tangga lainnya yang sering digunakan Ibu dalam kehidupan sehari hari.", "https://i.postimg.cc/2Sw8Prmm/tari-bondan.jpg"},
                {"5", "Tari Kukila", "Gerakan utama dalam Tari Kukila menggambarkan tingkah laku burung yang tergambar dalam gerakan Tari Kukila saat dipentaskan yang sangat dinamis, gesit dan lincah.", "https://i.postimg.cc/8sgzVCjk/tari-kukila.jpg"},
                {"6", "Tari Gambyong", "Tari Gambyong berasal dari Surakarta dan merupakan tari perpaduan dari tari kraton dan tari rakyat. Nama Gambyong diambil dari nama pencipta tarian ini, seorang Waranggana atau wanita yang ahli menari yakni “Mas Ajeng Gambyong”.", "https://i.postimg.cc/SRfKLMS0/Tari-Adat-Gambyong.jpg"},
                {"7", "Tari Kretek", "Tari Kretek berasal dari daerah Kudus, Jawa Tengah. Tarian ini menggambarkan kehidupan para buruh bersama dengan kreteknya. Kudus sudah lama dikenal dengan industri kreteknya dan menjadi penopang perekonomian masyarakat setempat.", "https://i.postimg.cc/J0xPfprp/Tari-Adat-Kretek.jpg"},
                {"8", "Tari Rancak Denok", "Tari Rancak Denok merupakan tari kreasi yang mengambil gagasan dari berbagai tari yang menggunakan topeng sebagai properti saat pementasan. Tarian ini menggunakan properti utama topeng dan umumnya ditarikan oleh wanita.", "https://i.postimg.cc/wBsH9msX/Tari-Adat-Rancak-Denok.jpg"},
                {"9", "Tari Serimpi", "Tari Serimpi adalah tari klasik yang berasal dari Jawa Tengah. Tari Serimpi ini muncul pada zaman kerajaan Mataram saat itu sedang dipimpin oleh Sultan Agung yaitu sekitar tahun 1613 – 1646. Tari Serimpi ini dianggap sakral karena hanya dipentaskan dalam lingkungan keraton untuk ritual kenegaraan dan peringatan kenaikan tahta Sultan.", "https://i.postimg.cc/1XDrSJyk/Tari-Adat-Serimpi.jpg"}
        };

        public static ArrayList<Tari> getListData(){
            ArrayList<Tari> list = new ArrayList<>();
            for (String[] aData : data){
                Tari tari = new Tari();
                tari.setId(Integer.parseInt(aData[0]));
                tari.setName(aData[1]);
                tari.setDescription(aData[2]);
                tari.setPhoto(aData[3]);

                list.add(tari);
            }
            return list;
        }
    }
