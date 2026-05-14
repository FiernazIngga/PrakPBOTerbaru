## 🚀 PrakPBOTerbaru - Game Pesawat Battle (Java Swing MVC)

### Deskripsi
Project ini adalah game 2D berbasis **Java Swing** dengan konsep pertarungan pesawat (airplane battle) yang dibuat untuk tugas Praktikum Pemrograman Berorientasi Objek (PBO).

Game ini mendukung:
- Player vs Player
- Player vs Bot (AI)
- Sistem HP, bullet, dan collision
- Efek ledakan (explosion animation)
- Penyimpanan history game ke database

---

### Gameplay
Dalam game ini, pemain mengendalikan pesawat untuk:
- Bergerak naik dan turun
- Menembak lawan
- Menghindari serangan
- Bertahan sampai HP habis

Mode game:
- 🧑‍🤝‍🧑 2 Player Mode
- 🤖 Bot Mode (otomatis)

---

### Fitur Utama

#### Combat System
- Bullet system dengan cooldown
- Collision detection
- HP system untuk player & enemy
- Game over condition

#### AI Bot
- Enemy bisa digantikan bot
- Bot memilih pesawat secara random
- Bot melakukan aksi otomatis

#### History Game (Database)
Game menyimpan data pertandingan:
- Nama pilot
- Nama pesawat
- Waktu mulai & selesai
- Catatan hasil pertandingan

Disimpan melalui:
- DAO (`DataHistoryGameDAO`)
- JDBC MySQL

---

### Arsitektur Project (MVC)
Project menggunakan struktur:

- **Model**
  - GameState
  - Entity (Player, Enemy, Bullet)
  - History Game Model

- **View**
  - PanelArenaGame (UI utama game)
  - Frame menu

- **Controller**
  - GamePesawat (input keyboard + logic)
  - GameController

- **DAO**
  - DataHistoryGameDAO (database handler)

---

### Asset Game
Game menggunakan asset:
- Background random (3 variasi)
- Pesawat player & enemy
- Sound effect (shooting & explosion)
- Animasi ledakan

---

### Cara Menjalankan

1. Clone repo
```bash
git clone https://github.com/FiernazIngga/PrakPBOTerbaru.git
```
2. Buka di Netbeans atau yang lain
3. Klik File → Open Project pilih `PrakPBOTerbaru`
4. Setup JDBC MySql Connector
5. Pastikan MySQL sudah berjalan 
6. Import `history_game.sql` 
7. Jalankan program dari `GameProject → src → gameproject → GameProject.java`
