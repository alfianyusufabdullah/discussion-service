package alfianyusufabdullah.discussionservice.data

import alfianyusufabdullah.discussionservice.model.Discussions

object Dummy {
    val discussions = listOf(
        mapOf(
            "discussion" to Discussions(
                comment = "selamat malam kak,mau bertanya:\n" +
                        "\n" +
                        "skala Nilai paling Minimal Untuk Bisa di Katakan Lulus skala Berapa Kak?\n" +
                        "\n" +
                        "mohon Penjelasannya kak.\n" +
                        "\n" +
                        "Terimakasih....!",
                name = "Gunawan",
                title = "pemberian nilai skala 1-5",
                createdAt = 1
            )
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Yang bintang maksudnya? Kalo soal bintang, dapat bintang satu pun itu udah dianggap lulus. Yang penting kriteria intinya dapat semua",
                name = "Trueerror",
                title = "-",
                createdAt = 2,
                parentId = "gunawan-1"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Yang bintang maksudnya? Kalo soal bintang, dapat bintang satu pun itu udah dianggap lulus. Yang penting kriteria intinya dapat semua",
                name = "Trueerror",
                title = "-",
                createdAt = 3,
                parentId = "trueerror-2"
            ),
        ),
        mapOf(
            "discussion" to Discussions(
                comment = "Apa sih web itu?aku belum memahami secara mendalam tentang pengertiannnya",
                name = "gordianus",
                title = "Apa sih web itu???",
                createdAt = 4
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Hai Kak,\n" +
                        "\n" +
                        "Pengertian web sudah dijelaskan secara padat dan langsung pada intinya di modul berikut https://www.dicoding.com/ac...\n" +
                        "\n" +
                        "Untuk pengertian dan penjelasan yang lebih lengkap, karena web ini termasuk hal yang pembahasannya sangat luas, Kakak bisa mulai mencari tahu tentunya melalui Wikipedia.",
                name = "mochamadboval",
                title = "-",
                createdAt = 5,
                parentId = "gordianus-4"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Lah, yg situ pake sekarang apaan? Kan web?",
                name = "Trueerror",
                title = "-",
                createdAt = 6,
                parentId = "gordianus-4"
            )
        ),
        mapOf(
            "discussion" to Discussions(
                comment = "kak sebelum mengirimkan project submission apakah harus mengikuti absesni online dulu kak ?",
                name = "Agus",
                title = "Tugas Submission",
                createdAt = 7
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Maaf ka. Saya bisa bertanya.???",
                name = "Jean",
                title = "-",
                createdAt = 6,
                parentId = "agus-7"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Silahkan",
                name = "Rifki",
                title = "-",
                createdAt = 8,
                parentId = "jean-6"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Halo kak, tidak apa-apa mengirimkan submission terlebih dahulu namun tetap harus Mengikuti online session sebanyak 1 (satu) sesi yang dibuktikan dengan absensi.",
                name = "Rifki",
                title = "-",
                createdAt = 9,
                parentId = "agus-7"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Saya sudah lulus mas, sudah mendapatkan sertifikat. Apakah harus ikut online session? Soalnya di dashboard dicoding ga ada pernyataan ikut kelas online lagi, mohon bantuannya",
                name = "Fahri",
                title = "-",
                createdAt = 10,
                parentId = "rifki-9"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Submission saya sudah saya kirim. Tp di tolak terus kalo..\n" +
                        "Padahal. Sya sudah.. mengikuti kriterianya. Dgn benar..!!",
                name = "Jean",
                title = "-",
                createdAt = 11,
                parentId = "rifki-9"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Apakah ada catatan dari reveiwer ?",
                name = "Rifki",
                title = "-",
                createdAt = 12,
                parentId = "jean-11"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Mohon bantuannya ka. Soalnya saya sudah dtolak berkali kali dgn alasan yg sama. \"Semua kriteria tidak terpenuhi\". Tp semuanya saya sudah penuhi.!!!\n" +
                        "\n" +
                        "Salah saya d mana ka.??\n" +
                        "Sekali lagi MOHON BANTUANNYA ka!! Atau bila perlu saya kirim submission ke emailnya Kaka saja biar. Saya dpat penjelasan lebih.\n" +
                        "\n" +
                        "Sudah mau menyerah saya ini ka.!!!. Soalnya d tolak terusss. Salahnya dimana!!!!!!!!!??",
                name = "Jean",
                title = "-",
                createdAt = 12,
                parentId = "rifki-12"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Katanya belum memenuhi semua kriteria ka. Tp saya sudah memenuhi semua kriteria ka. Bahkan submision yg saya buat tu. Sesuai degan kriteria untuk mendapatkan bintang..ka.\n" +
                        "\n" +
                        "Saya jd bingung. Salah saya dimana.??",
                name = "Jean",
                title = "-",
                createdAt = 13,
                parentId = "rifki-12"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Mohon dibaca kembali catatan review yang diberikan ya kak",
                name = "Dimas",
                title = "-",
                createdAt = 14,
                parentId = "rifki-12"
            ),
        ),
        mapOf(
            "comment" to Discussions(
                comment = "Halo kak, submissionnya pakai bootstrap kah ?\n" +
                        "\n" +
                        "Sebaiknya membuat css sendiri dan tidak Menggunakan library Bootstrap, Materialize, Foundation, ataupun library lain yang semacamnya untuk menyusun layout.",
                name = "Rifki",
                title = "-",
                createdAt = 15,
                parentId = "rifki-12"
            ),
        ),
    )
}