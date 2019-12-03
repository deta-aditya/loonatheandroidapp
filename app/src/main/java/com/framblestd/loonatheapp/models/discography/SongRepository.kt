package com.framblestd.loonatheapp.models.discography

import com.framblestd.loonatheapp.R
import com.framblestd.loonatheapp.models.member.Member
import com.framblestd.loonatheapp.models.member.MemberRepository
import com.framblestd.loonatheapp.models.member.SubUnit
import java.io.Serializable

@Suppress("UNCHECKED_CAST")
object SongRepository {
    private val values = arrayOf(

        arrayOf(
            "ViViD",
            arrayOf(1),
            "HeeJin",
            "GDLO, 박지연 (MonoTree)",
            "G-high, 최영경 (MonoTree)",
            "G-high (MonoTree), 정수완",
            "Lo-Fi, Groovy",
            201,
            R.drawable.cover_vivid,
            "https://open.spotify.com/track/4STsLimXfiydKp7WwJYoFh?si=dVOHAQ6gRiyaD0AOfvkRTw",
            "https://www.youtube.com/watch?v=-FCYE87P5L0",
            "\"ViViD\" is a colorful-feeling lo-fi track, which shows off HeeJin's character with clarity. It tells a story of meeting a person to love in a repetitive and colorless routine, and only then finding a vivid color within oneself."
        ),

        arrayOf(
            "ViViD (Acoustic Ver.)",
            arrayOf(1),
            "HeeJin",
            "GDLO, 박지연 (MonoTree)",
            "G-high, 최영경 (MonoTree)",
            "G-high (MonoTree)",
            "Acoustic",
            216,
            R.drawable.cover_vivid_accoustic,
            "https://open.spotify.com/track/0Y8wd59ekQxkcSN9lyMG7A?si=ENAIiKetR7SAZZ6vVGZrGg",
            "https://www.youtube.com/watch?v=pYbUP6qkU7M",
            "On the other hand, the acoustic mix of \"ViViD\" changes the original into a groovy guitar-based track, with HeeJin's delicate sense of rhythm being a pleasure. The acoustic version's music video was filmed in Paris by VAM Production."
        ),

        arrayOf(
            "I'll Be There",
            arrayOf(1, 2),
            "HyunJin",
            "Artronic Waves, David Kater",
            "Artronic Waves, David Kater",
            "Artronic Waves",
            "Dance, Funk Pop",
            188,
            R.drawable.cover_ill_be_there,
            "https://open.spotify.com/track/38s2E3OM2UJY6EO8siwz81?si=zJ-o4ooLTP-In9hu5EkLRA",
            "",
            "Dual-title track \"I'll Be There\" is the first song that brings HyunJin and HeeJin together, a candy-funk track notable for the fresh charm that pops off from the very first line. This track was also filmed entirely in Harajuku, Tokyo, and presents music and video that suggests an overall direction for Loona, a girlgroup that can already give off a fully packed vibe with just two members."
        ),

        arrayOf(
            "Around You (다녀가요)",
            arrayOf(2),
            "HyunJin",
            "Lee Joo Hyung (MonoTree)",
            "Lee Joo Hyung (MonoTree)",
            "Lee Joo Hyung (MonoTree)",
            "Ballad",
            209,
            R.drawable.cover_around_you,
            "https://open.spotify.com/track/5hKU02nIlA7m5G0tHFZueF?si=hYmhpbPvQm-o1r6Z3XUJAQ",
            "",
            "\"Around You\" is a teenage ballad track that has not been heard in some time, which paints the emotions of a beautiful crush that an adolescent girl might have upon a piano melody. The video accompanying \"Around You\", entirely filmed in Tokyo, include an 8-minute film version which is reminiscent of a Japanese romance film as well as a music video version."
        ),

        arrayOf(
            "The Carol",
            arrayOf(3, 2, 1),
            "HaSeul",
            "G-High, Choi Young Gyung (MonoTree)",
            "G-High, Choi Young Gyung, Asher Park (MonoTree)",
            "G-High, Asher Park (MonoTree)",
            "Holiday",
            206,
            R.drawable.cover_carol,
            "https://open.spotify.com/track/3lLoJVI9eif5kAsL4rk8um?si=asVldPCDSUWMyJdO5amrtg",
            "",
            "\"The Carol\", which stars HaSeul alongside HeeJin and HyunJin, is LOONA's first seasonal song. LOONA's own Christmas theme, as clear as its title, was produced with MonoTree, and its music video was filmed in London and expresses a giddy feeling like that of an excited girl on Christmas."
        ),

        arrayOf(
            "Let Me In (소년, 소녀)",
            arrayOf(3),
            "HaSeul",
            "OREO",
            "OREO",
            "Ung Kim (OREO)",
            "Ballad, Opera",
            187,
            R.drawable.cover_let_me_in,
            "https://open.spotify.com/track/0vziFOaBxXNZaVG9pLXfQq?si=BNi5mgiATE6ANyTnL02HxA",
            "",
            "Haseul's \"Let Me In\", by the production team OREO led by Iggy who completed GFriend's school-themed trilogy, is a blockbuster track that starts as a calm winter ballad before strings roar over like a blizzard.\n" +
                    "\n" +
                    "Digipedi and Blockberry Creative filmed in faraway Iceland for the music video, and fulfilled the music's scale through the scenery of Iceland."
        ),

        arrayOf(
            "Kiss Later (키스는 다음에)",
            arrayOf(4),
            "YeoJin",
            "Hwang Hyun, Shin Agnes (MonoTree)",
            "Hwang Hyun (MonoTree)",
            "Hwang Hyun (MonoTree)",
            "Candy Pop",
            199,
            R.drawable.cover_kiss_later,
            "https://open.spotify.com/track/6WLfBd2KFL8iuU57qy9HqI?si=8GBSumC8TvKv77WeXs3HlQ",
            "",
            "Title track \"Kiss Later\" is an upbeat and lively candy-pop song, containing YeoJin's own uniqueness. The lyrics express an appropriate and healthy attitude telling a boyfriend that \"we're still young, so let's study hard and get into college before kissing\".\n" +
                    "\n" +
                    "The music video of \"Kiss Later\" was produced under the direction of Digipedi, the nation's top music video producer, and contains fancy cinematography befitting YeoJin with the fairytale \"The Frog Prince\" as motif."
        ),

        arrayOf(
            "My Sunday",
            arrayOf(2, 1),
            "YeoJin",
            "GDLO, Shin Agnes (MonoTree)",
            "Kim Yoo Seok, Choo Dae Kwan, GDLO (MonoTree)",
            "Choo Dae Kwan, Kim Yoo Seok (Monotree)",
            "Pop",
            182,
            R.drawable.cover_my_sunday,
            "https://open.spotify.com/track/0ij8esbxdXCUIUfcKwfzJu?si=LxdYgkxwQcShCpNxs1QFIA",
            "",
            "\"My Sunday\" and \"My Melody\" are twinned tracks which is being attempted for the first time globally. They are comprised of the same arrangement, but progress in two different melodies in the chorus. Fans will discover two charms that seem similar but different. The music videos for \"My Sunday\" and \"My Melody\" were filmed entirely in Taiwan, framing Loona's refreshing charms."
        ),

        arrayOf(
            "My Melody",
            arrayOf(4, 3),
            "YeoJin",
            "GDLO, Shin Agnes (MonoTree)",
            "Kim Yoo Seok, Choo Dae Kwan, GDLO (MonoTree)",
            "Choo Dae Kwan, Kim Yoo Seok (Monotree)",
            "Pop",
            182,
            R.drawable.cover_my_melody,
            "https://open.spotify.com/track/5jfEwcinJx9m2tQlYwL644?si=eyGBL-VaTi2bx8QW6b5wBg",
            "",
            "\"My Sunday\" and \"My Melody\" are twinned tracks which is being attempted for the first time globally. They are comprised of the same arrangement, but progress in two different melodies in the chorus. Fans will discover two charms that seem similar but different. The music videos for \"My Sunday\" and \"My Melody\" were filmed entirely in Taiwan, framing Loona's refreshing charms."
        ),

        arrayOf(
            "Into the New Heart (Guitar by Jungmo of TRAX)",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ 1/3")),
            "Love & Live",
            "None",
            "Hwang Hyun, Nopari (MonoTree)",
            "Hwang Hyun",
            "Metal",
            67,
            R.drawable.cover_itnh,
            "https://open.spotify.com/track/5IOZOsb4Y8K90YC54oKm3n?si=YZJXGldeSHySTxXClcsXKQ",
            "",
            "Intro track \"Into the New Heart\" is a heavy-metal track which may be remembered as the most unique intro in girlgroup history. In particular, Kim Jungmo of TRAX, who was among the first generation of Korean visual-kei bands, helped kick off the album vigorously with satisfying guitar drives."
        ),

        arrayOf(
            "지금, 좋아해 (Love & Live)",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ 1/3")),
            "Love & Live",
            "Hwang Hyun (MonoTree)",
            "Hwang Hyun (MonoTree)",
            "Hwang Hyun (MonoTree)",
            "Pop",
            206,
            R.drawable.cover_love_and_live,
            "https://open.spotify.com/track/5IOZOsb4Y8K90YC54oKm3n?si=c2qwuBMMQuyD2vRnMFGpCg",
            "",
            "The \"Love & Live\" music video is a story about the identity and love of Android ViVi. After running, she thinks I'm going to look at other girls who breathe and get tired. \"Why is it not as hard for me as it is for my friends? Why is my heart not beating faster? I want to be excited.\" ViVi, who ran and ran until her chest was running, finally stops in a strange way."
        ),

        arrayOf(
            "You and Me Together",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ 1/3")),
            "Love & Live",
            "Artronic Waves, David Kater",
            "Artronic Waves, David Kater",
            "Artronic Waves",
            "Funk",
            207,
            R.drawable.cover_yamt,
            "https://open.spotify.com/track/1KxfMKXJdkr7vMAvFnlw3s?si=DBYfGMh6SxG_BM-rhFmw9Q",
            "",
            "Sub-title track \"You and Me Together\" is a candy-funk track produced by Artronic Waves for the second time since HeeJin and HyunJin's \"I'll Be There\". It brings good feelings to the listener with a refreshing sound like bursting fruit juices, a signature sound of LOONA."
        ),

        arrayOf(
            "Fairy Tale",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ 1/3")),
            "Love & Live",
            "Artronic Waves",
            "Artronic Waves",
            "Artronic Waves",
            "Ballad, Lullaby",
            187,
            R.drawable.cover_itnh,
            "https://open.spotify.com/track/4KwPYWo3LWjAuHMQeQ2KgU?si=pqzLmmUfQxiMylvl22wEyw",
            "",
            "\"Fairy Tale\" gently flows to the ear with a melody that's like a bedtime fairytale from childhood."
        ),

        arrayOf(
            "3월을 기다려 (Valentine Girl)",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ 1/3")),
            "Love & Live",
            "Hwang Hyun (MonoTree)",
            "Hwang Hyun (MonoTree)",
            "Hwang Hyun (MonoTree)",
            "Pop",
            190,
            R.drawable.cover_valentine,
            "https://open.spotify.com/track/4SLf5mA4iIPTgN9GwS1Ot1?si=k-aL5rEjQW68SwbJaoXBCA",
            "",
            "Final track \"Valentine Girl\" was previously teased to fans in February. It is a happy-tempo track telling the story of gifting chocolate to a boy on Valentine's Day, then hoping to hear confessions of love from that boy on March's White Day."
        ),

        arrayOf(
            "Everyday I Love You (feat. HaSeul)",
            arrayOf(5, 3),
            "ViVi",
            "Yun Yeong Min, 노는 어린이(Noneun Eorini), Kim Nam Yeong",
            "노는 어린이(Noneun Eorini), Yun Yeong Min, Kim Nam Yeong, Melody Gong Jak So",
            "노는 어린이(Noneun Eorini), Yun Yeong Min, Melody Gong Jak So",
            "Pop",
            208,
            R.drawable.cover_edily,
            "https://open.spotify.com/track/308axn5I8B398prJ8kuac6?si=VJ4HjI2CQJiuqyNIw56hug",
            "",
            "The story of the \"Everyday I Love You\" music video was created by restoring the memory of ViVi's life, before ViVi was converted to an Android."
        ),

        arrayOf(
            "Everyday I Need You (feat. JinSoul)",
            arrayOf(5, 7),
            "ViVi",
            "노는 어린이(Noneun Eorini), Yun Young Min, Kim Nam Young",
            "노는 어린이(Noneun Eorini), Yun Young Min, Kim Nam Young",
            "노는 어린이(Noneun Eorini), Yun Young Min, Kim Nam Young",
            "Pop",
            187,
            R.drawable.cover_ediny,
            "https://open.spotify.com/track/652eEVQkB5nmyLgu9ylmfl?si=miX3N0WBRsm3ia5PwXYRqA",
            "",
            "The medium-mix version of the title track, \"Everyday I Need You\", features a yet-unrevealed Loona member named JinSoul in a groovy rap performance and her first appearance to fans."
        ),

        arrayOf(
            "Love & Evil",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ 1/3")),
            "Love & Evil",
            "None",
            "Sweetch (MAJORIG), Meng이",
            "Sweetch (MAJORIG), Meng이",
            "Instrumental",
            62,
            R.drawable.cover_love_and_evil,
            "https://open.spotify.com/track/3307jEqptKGpAa3THFheVu?si=r6PVXJaWRZi4zeJBa7o8wQ",
            "",
            "The intro track ‘Love & Evil’ produced by SWEETCH materializes a girl who is lost alone in a dark forest. With the piano played in Accelerando, the girl runs away deeper into the forest.\n" +
                    "\n" +
                    "Four girls then gather to sing a ‘Sonatine’ to cast an arcane spell of love. "
        ),

        arrayOf(
            "알 수 없는 비밀 (Sonatine)",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ 1/3")),
            "Love & Evil",
            "Sweetch (MAJORIG), No Ju Hwan",
            "Sweetch (MAJORIG), No Ju Hwan, Mengi",
            "Mengi, Sweetch (MAJORIG), No Ju Hwan",
            "Ballad, Fantasy, Neo-Medieval",
            62,
            R.drawable.cover_sonatine,
            "https://open.spotify.com/track/2e8qWdt5W3wWxAs3L3DRqJ?si=9Py0AUugTrugpx6RxiSfHw",
            "",
            "The track takes the encounters of love away towards the adolescence of the girls. While \"Love & Live (지금, 좋아해)\" was a typical K-pop girl group track with lovely emotions, \"Sonatine (알 수 없는 비밀)\" mesmerizes the audience with mystical melodies unexpected for a K-pop girl group.\n" +
                    "\n" +
                    "Four girls gather to sing a ‘Sonatine’ to cast an arcane spell of love."
        ),

        arrayOf(
            "비의 목소리 51Db (Rain 51Db)",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ 1/3")),
            "Love & Evil",
            "Oreo",
            "Oreo",
            "Oreo",
            "90s Pop",
            201,
            R.drawable.cover_rain51db,
            "https://open.spotify.com/track/5n7igdr3vMrBA8tUTEqDyd?si=EgWn_4b2T8KTQ_-_Ti4Rmw",
            "",
            "This song is an homage to the first generation K-pop girl groups, S.E.S and Fin.K.L. It also shows the girls love towards themselves, trying to revitalize the sentiments of the golden era. Like ViVi’s previous attempt in \"Everyday I Love You\", LOONA 1/3 time-travels back to the 90’s, with the question of “what if LOONA was created in the 90’s?”. They then raise their innocent and pure voices up as if ‘Rain 51db’ is the original soundtrack to an animation film with a storytelling, singing that they have “dreams that they do not wake up from.”"
        ),

        arrayOf(
            "Eclipse",
            arrayOf(6),
            "Kim Lip",
            "Park Ji Yeon, Hwang Hyun (MonoTree)",
            "Daniel Obi Klein & Charli Taft",
            "Daniel Obi Klein & Charli Taft",
            "Urban R&B, Dance",
            231,
            R.drawable.cover_eclipse,
            "https://open.spotify.com/track/1GG5C0ugHo4OWjZUSe0zgp?si=fyiy4h-LQimbpgNlJfEFrw",
            "",
            "The title track, 'Eclipse' is an urban R&B track produced by Daniel Obi Klein, the producer of E-Sens' critically acclaimed album 'The Anecdote'. While LOOΠΔ 1/3 has asked questions about love, the sweetness, the pain, the joy, the worries, and hidden emotions, Kim Lip tells without any hesitation that \"love just happens like it's destined to,\" in the lyrics."
        ),

        arrayOf(
            "Twilight",
            arrayOf(6),
            "Kim Lip",
            "Lee Ji Eun, Kim Tae Sung",
            "Kim Tae Sung, Cha Cha Malone, Song Ji Eun",
            "Cha Cha Malone",
            "Ballad Pop",
            186,
            R.drawable.cover_twilight,
            "https://open.spotify.com/track/7plTNMglT8GI4bqptvMHMh?si=eR8TOaykTjmR8_EB4h6mHw",
            "",
            "\"Even the moonlight feels like you,\" she [Kim Lip] says in the supporting track 'Twilight', singing through a sleepless night towards the moon. Cha Cha Malone, the producer of AOMG wrote the song for Kim Lip, adding a deeper tint to Kim Lip's color red."
        ),

        arrayOf(
            "Singing In The Rain",
            arrayOf(7),
            "JinSoul",
            "Hwang Hyun & Park Ji Yeon (MonoTree)",
            "Ludwig Lindell, Daniel Caesar, Nils Pontus, Petersson, Karl Oskar-Julius & Gummesson",
            "Karl Oskar-Julius & Gummesson",
            "Future Bass",
            211,
            R.drawable.cover_singing_in_the_rain,
            "https://open.spotify.com/track/2wSKuveB7iYLSOg7qeldzj?si=8HPpF4zBSeuS9vHLOjX0qw",
            "",
            "Dressed in a blue school uniform, she [JinSoul] brings a future bass track, 'Singing in the Rain' to show her colors to the fullest. The track fires up speakers with its accelerating tempo like a pulsating heart in excitement."
        ),

        arrayOf(
            "Love Letter",
            arrayOf(7, 6),
            "JinSoul",
            "Park Ji Yeon, 신아녜스 (Shin Agnes)",
            "Lee Joo Hyung, NOPARI (MonoTree)",
            "NOPARI (MonoTree)",
            "Ballad Pop",
            188,
            R.drawable.cover_love_letter,
            "https://open.spotify.com/track/1B4ZWnHelZoizJnWzmSzwy?si=Y5bjOTwWQ56ZWwF_RmejEg",
            "",
            "The title of the supporting track 'Love Letter' performed by JinSoul and Kim Lip sounds like a ballad number, but it actually is a track full of groove, created from the clash of the two girls with their unique and distinct styles."
        ),

        arrayOf(
            "Love Cherry Motion",
            arrayOf(8),
            "Choerry",
            "Hwang Hyun, Shin Agnes (MonoTree)",
            "Ollipop, Hayley Aitken, Kanata Okajima",
            "Ollipop, Hayley Aitken",
            "Dance, Pop, Ethnic Beat",
            221,
            R.drawable.cover_love_cherry_motion,
            "https://open.spotify.com/track/1H3i6WXxrJB7LEoH5iStvb?si=eZfoOc04RaCuS9FZAHFieQ",
            "",
            "Choerry’s title track ‘Love Cherry Motion’ is a funky pop dance tune blasting through hot summer, demonstrating Choerry’s juicy charm. The love spell ‘Love Cherry Motion’ is produced with the opposing qualities of refreshingly explosive chorus and ethnic break beats to create its own sense of style in finesse. "
        ),

        arrayOf(
            "Puzzle",
            arrayOf(8, 7),
            "Choerry",
            "Park Ji Yeon, G-high (MonoTree)",
            "Daniel Obi Klein, Charlotte Taft, Andreas Oberg",
            "Daniel Obi Klein, Charlotte Taft, Andreas Oberg",
            "Pop",
            220,
            R.drawable.cover_puzzle,
            "https://open.spotify.com/track/0Y1oSjd9U7Qy5t7EDjAjPq?si=UbC5CpH_T4SAw_lgcY7Tgg",
            "",
            "The supporting track ‘Puzzle’ is a duet by JinSoul and Choerry, produced by Daniel Obi Klein who also produced Kim Lip’s ‘Eclipse’. JinSoul's vocal flair and Choerry’s beautiful harmonies become the pieces of the ‘Puzzle’ being put together."
        ),

        arrayOf(
            "ODD",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ Odd Eye Circle")),
            "Mix & Match",
            "G-high (MonoTree)",
            "Ollipop, Hayley Aitken",
            "Ollipop, Hayley Aitken",
            "Dance",
            220,
            R.drawable.cover_odd,
            "https://open.spotify.com/track/3GRwM20EPVWjKoVsNsHjrj?si=HwbiYA-jS6SSuUKbhGWv8Q",
            "",
            "The intro track to express ODD EYE CIRCLE’s identity. Girls who have released solo singles each have gathered to sing under the name ‘ODD EYE CIRCLE’. They say that we’re all ODD as people."
        ),

        arrayOf(
            "Girl Front",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ Odd Eye Circle")),
            "Mix & Match",
            "Park Ji Yeon, Hwang Hyun (Monotree), Jaden Jeong",
            "Ollipop, Hayley Aitken",
            "Ollipop, Hayley Aitken",
            "Dance",
            196,
            R.drawable.cover_girl_front,
            "https://open.spotify.com/track/5OnchRw2yAuIAwp2RYLCBa?si=CTQsoTEOStyLzBF0D4Bt7w",
            "",
            "This song depicts new standards of girls asking the boys out and expressing their love with dignity. Kim Lip’s \"Eclipse\", JinSoul's \"Singing in the Rain\", and Choerry's \"Love Cherry Motion\" merges in this track to form a new structure as a metaphor of three moons (ODD) gathering to form a new team."
        ),

        arrayOf(
            "LOONATIC",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ Odd Eye Circle")),
            "Mix & Match",
            "G-High (MonoTree)",
            "G-High, Kim Yoo Seok (MonoTree)",
            "G-High, Kim Yoo Seok (MonoTree)",
            "Dream Pop",
            180,
            R.drawable.cover_loonatic,
            "https://open.spotify.com/track/2FwFu6y1aXPWXWcD9RxA6v?si=qcwZT_izR7yzbYPfk0rsdg",
            "",
            "The track is in the styles of dream pop which has almost never been done in Korea to satisfy both international and local fans. Be ready to experience a musical roller-coaster ride."
        ),

        arrayOf(
            "Chaotic",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ Odd Eye Circle")),
            "Mix & Match",
            "Artronic Waves, Safira K., David Kater",
            "Artronic Waves, David Kater",
            "Artronic Waves",
            "Pop",
            180,
            R.drawable.cover_chaotic,
            "https://open.spotify.com/track/4wOXL5AcwYT1Lc8IuqZfot?si=V2dOQOeVQWSjoChfMyr-cQ",
            "",
            "A track that emphasizes ODD EYE CIRCLE's vocalist techniques. The song was initially chosen to be the title track for BlockBerryCreative's 8x8x8, but it was changed to showcase ODD EYE CIRCLE's technical vocal skills. Thus, you can feel ODD EYE CIRCLE's unique charm as they can express their music to be 'manish'."
        ),

        arrayOf(
            "Starlight",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ Odd Eye Circle")),
            "Mix & Match",
            "GDLO, Park Ji Yeon (MonoTree)",
            "Hyuk Shin (Joombas), NOPARI (MonoTree), JJ Evans (Joombas)",
            "NOPARI (MonoTree)",
            "Pop Ballad",
            201,
            R.drawable.cover_chaotic,
            "https://open.spotify.com/track/4wOXL5AcwYT1Lc8IuqZfot?si=V2dOQOeVQWSjoChfMyr-cQ",
            "",
            "Fans who like LOOΠΔ 1/3 might be surprised with ODD EYE CIRCLE as their music is in the complete opposite style. While LOOΠΔ 1/3 has focused to create sounds of cliche images of young girls, ODD EYE CIRCLE is creating their music in the original shapes of a girl-crush in the form of a pop-tune. They’ve put stories among girls, more important than stories about boys, into this track, Starlight. Story told under the starlight endlessly until the morning comes."
        ),

        arrayOf(
            "ADD",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ Odd Eye Circle")),
            "Max & Match",
            "None",
            "NOPARI, GDLO, Hwang Hyun (MonoTree)",
            "NOPARI, GDLO, Hwang Hyun (MonoTree)",
            "Dance",
            71,
            R.drawable.cover_add,
            "https://open.spotify.com/track/4NzNeHybw9rIbbRb7ztgfm?si=3u_WGmrsQ1SmcLgZowqfsg",
            "",
            "The intro track of [Max&Match], \"ADD\", is a new take on the music from the teaser video clip for ODD EYE CIRCLE, \"Reveal\". It starts with a dreary ambiance, which beats were then added. "
        ),

        arrayOf(
            "Sweet Crazy Love",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ Odd Eye Circle")),
            "Max & Match",
            "Park Ji Yeon (MonoTree)",
            "Daniel Kim, Charli Taft, Thomas Sardorff, G-high (MonoTree)",
            "Daniel Kim, Charli Taft, Thomas Sardorff, G-high (MonoTree)",
            "R&B, Dream Pop, Dance",
            209,
            R.drawable.cover_sweet_crazy_love,
            "https://open.spotify.com/track/5fgpCIjBJ098E9zqN9DS87?si=IB5MmhlWS1WBghrVBvd3zw",
            "",
            "The intro track of [Max&Match], \"ADD\", is a new take on the music from the teaser video clip for ODD EYE CIRCLE, \"Reveal\". It starts with a dreary ambiance, which beats were then added. "
        ),

        arrayOf(
            "Uncover",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ Odd Eye Circle")),
            "Max & Match",
            "G-high (MonoTree)",
            "G-high (MonoTree)",
            "G-high (MonoTree)",
            "Dream Pop",
            200,
            R.drawable.cover_uncover,
            "https://open.spotify.com/track/2oFbMd0TcgUm7Df4Sx16h9?si=myyeQyCrSPi9PhFdcU7mBg",
            "",
            "Another dream pop track following \"LOONATIC\" is a newly released \"Uncover\", showing off the confidence in the music production aspect of LOOΠΔ. Dream pop, a genre known to be extremely difficult to be expressed in the context of k-pop, has once again been flawlessly produced in the color of ODD EYE CIRCLE to add to the masterfulness of the album."
        ),

        arrayOf(
            "new",
            arrayOf(9),
            "Yves",
            "Park Ji Yeon (MonoTree), Jaden Jeong",
            "Brooke Toia, Daniel Caesar, Ludwing Lindell",
            "Brooke Toia, Daniel Caesar, Ludwing Lindell",
            "Soultronica",
            184,
            R.drawable.cover_new,
            "https://open.spotify.com/track/7eUtsnBNOWfWDObBZyU4F4?si=-tUiSP7GSMOixcOtYX4j5A",
            "",
            "Yves asks a question in Eden. “Is it really a bad thing to disobey God?” If someone has already decided our fate, wouldn’t it be a better life to stand up and against that fate?\n" +
                    "\n" +
                    "Even if it’s not something grand such as God or fate, Yves sings that she will not surrender herself to any walls or glass ceilings she may have to face.\n" +
                    "\n" +
                    "The title track “new” is a song where Yves declares that she will be herself no matter what kind of hardships, pain, and frustration faces her. It is the first track released in the genre of Soultronica in Korea, with Yves’ confident voice laid on top of bold beats to prove LOOΠΔ’s new concept and quality.\n" +
                    "\n" +
                    "The music video for “new” was directed by DigiPedi. He captures fatal images of Yves, who takes a bite of the apple on purpose to be exiled to the earth. "
        ),

        arrayOf(
            "D-1",
            arrayOf(9),
            "Yves",
            "G-High (MonoTree)",
            "G-High, Choi Young Gyung (MonoTree)",
            "G-High (MonoTree)",
            "French Pop",
            199,
            R.drawable.cover_d_1,
            "https://open.spotify.com/track/4ddaY4PJxvq47qIps1KQ6Q?si=dlwACWKeSUCGdP9u3fbCjQ",
            "",
            "The supporting track “D-1” is a French-pop style track with trivial emotions and stories of a girl told in a classy way."
        ),

        arrayOf(
            "The Carol 2.0",
            arrayOf(5, 8, 9),
            "The Carol 2.0",
            "Park Ji Yeon, GDLO",
            "G-High, Park Asher, Choi Yong Kyung",
            "Park Asher, G-High",
            "Holiday",
            206,
            R.drawable.cover_carol_2,
            "https://open.spotify.com/track/5gkbQEgYlXajuf8CcYpojE?si=hTKM7z48SiaCGZqCsi1x7A",
            "",
            "'The Carol 2.0' is performed by ViVi from LOOΠΔ 1/3, Choerry from LOOΠΔ / ODD EYE CIRCLE, and Yves who escaped from Eden, to create a transverse unit named 'ViRryVes' in order to welcome the holiday season along with the fans of LOOΠΔ. "
        ),

        arrayOf(
            "Heart Attack",
            arrayOf(10),
            "Chuu",
            "Park Ji Yeon (MonoTree)",
            "Ollipop, Hayley Aitken",
            "Ollipop, Hayley Aitken",
            "Holiday Pop",
            195,
            R.drawable.cover_heart_attack,
            "https://open.spotify.com/track/6SSC9KZQaxBdyipKRigrFC?si=Kwj5-gs1RZi2H4hG4cD-IA",
            "",
            "The titled track \"Heart Attack\" does not interpret the feelings of being in love in a serious way, but with Chuu’s own adorable emoticon-like ways. The music video has references to historical and fictional figures such as the artist Rene Magritte, Hans Christian Andersen’s short story \"The Little Match Girl\", and John Appleby’s novel \"Aphrodite Means Death\"."
        ),

        arrayOf(
            "Girl's Talk",
            arrayOf(10, 9),
            "Chuu",
            "G-high, Son Ko Eun (MonoTree)",
            "G-high, Son Ko Eun (MonoTree)",
            "G-high (MonoTree)",
            "Funk, EDM",
            197,
            R.drawable.cover_girls_talk,
            "https://open.spotify.com/track/1j3zXAq0W9cLIpiAXwcYXF?si=TmnnDagCRBycq8E1kRJuzw",
            "",
            "The supporting track \"Girl’s Talk\" is a duet by Chuu and Yves, a rendition of a daily dialogue between two girls. Sweet but sometimes secretive, the precious chats between the girls get reinterpreted to become a song. G-High of Monotree, who has produced HeeJin’s \"ViViD\" and ODD EYE CIRCLE’s \"Uncover\", crafts the track to perfection to prove the quality. "
        ),

        arrayOf(
            "One & Only",
            arrayOf(11),
            "Go Won",
            "Park Ji Yeon (MonoTree)",
            "Darren Smith, Tammy)",
            "Darren \"BabyDeeBeats\" Smith",
            "Pop",
            175,
            R.drawable.cover_one_and_only,
            "https://open.spotify.com/track/1DzpZ8HBR0MgGkZDhAdd7f?si=76-ihq-ARhGOmH99Fvx4_Q",
            "",
            "Go Won’s titled track ‘One&Only’ is about self-love.\n" +
                    "\n" +
                    "Even when it feels like the existence of oneself seems irrelevant in the world and may feel very little among others, Go Won sings, “it’s not a coincidence that I’ve met myself” and emphasizes how she met herself, ‘one and only’, is precious.\n" +
                    "\n" +
                    "The version of the ‘One&Only’ distributed online has been mixed in 3-D to stimulate stereognostic perception of the listeners when listened on either earphones or headphones. The CD version of the track will be the ‘original mix’ version as a perk for fans who purchase the CD. "
        ),

        arrayOf(
            "See Saw (feat. Kim Lip)",
            arrayOf(11, 10, 6),
            "Go Won",
            "moonc",
            "moonc, Rhoyzk",
            "moonc, Rhoyzk",
            "Ballad",
            201,
            R.drawable.cover_see_saw,
            "https://open.spotify.com/track/1tLmp8dEhaHvU0jm2aG6sS?si=V5xP9jlSTZWHZej0VPGVlA",
            "",
            "‘See Saw’ the supporting track which is a duet of Chuu and Go Won, defies the typical grammar of the k-pop genre to expand the boundaries of music with the uniqueness of LOOΠΔ. Chuu’s refreshing voice along with Go Won’s adolescent voice create the dynamic balance like riding a see-saw."
        ),

        arrayOf(
            "Egoist (feat. JinSoul)",
            arrayOf(12, 7),
            "Olivia Hye",
            "Park Ji Yeon (MonoTree), Jaden Jeong",
            "Artonic Waves, LAB301, PABLO GROOVE, Lafée",
            "Artonic Waves, LAB301, PABLO GROOVE",
            "EDM",
            247,
            R.drawable.cover_egoist,
            "https://open.spotify.com/track/5UUeEljsNQroCUNId8DIV6?si=w6VUh6WqQvaWf47lgPpikg",
            "",
            "Olivia Hye's titled track 'Egoist’ starts with calm melodies to eventually encounter provocative beats to take a step towards loving oneself instead of someone else. Pop melodies mix with EDM beats to build up until a dramatic fall at the beat drop, which then is brought to salvation by JinSoul's rap.\n" +
                    "\n" +
                    "Also, the music video features Olivia Hye's dynamic movements, along with hidden cuts around the narratives of LOOΠΔ. "
        ),

        arrayOf(
            "Rosy (feat. HeeJin)",
            arrayOf(12, 11, 1),
            "Olivia Hye",
            "Park Ji Yeon (MonoTree), Jaden Jeong",
            "Artonic Waves, LAB301, PABLO GROOVE, Lafée",
            "Artonic Waves, LAB301, PABLO GROOVE",
            "Pop",
            194,
            R.drawable.cover_rosy,
            "https://open.spotify.com/track/6cfacimNXWogsp6DtJflyL?si=6_PkerW0SiGui9m77TiUQg",
            "",
            "Go Won and Olivia Hye's duet 'Rosy' captures the pretty but edgy unpredictable emotions of modern girls who are nice but chic, kind but naughty, or interested but not enough to go out with someone."
        ),

        arrayOf(
            "dal segno",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ yyxy")),
            "beauty&thebeat",
            "None",
            "Artronic Waves, Billie Jean (BADD), Slyberry (BADD)",
            "Artronic Waves, Billie Jean (BADD), Slyberry (BADD)",
            "Instrumental",
            66,
            R.drawable.cover_dal_segno,
            "https://open.spotify.com/track/2GkF0nk8gmLYru7UZcZA9K?si=sRL9cgUSTGqy1P6_UjSXKg",
            "",
            "The definition of 'dal segno' the title of the intro track is 'return to segno'. The time of youth, which goes around and around in the same loop without their own intentions seemed like 'dal segno'.\n" +
                    "\n" +
                    "In the loop, they find the light that lets them discover their own ego. "
        ),

        arrayOf(
            "love4eva (feat. Grimes)",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ yyxy")),
            "beauty&thebeat",
            "Darly, Jaden Jeong",
            "Billie Jean (BADD), Narae (BADD), Kim Jin Hyung (BADD), E-TRIBE",
            "Billie Jean (BADD)",
            "Pop",
            220,
            R.drawable.cover_love4eva,
            "https://open.spotify.com/track/4rKEmhNA19JezqVsSQS4yo?si=HIOUr4rNRbis48TGlDauAA",
            "",
            "E-TRIBE, the maestro of dance music known for producing SNSD's 'Gee', and an upcoming production team 'BADD' have collaborated to produce the track where the members of LOONA/yyxy completed \"love4eva\" with their various voice colors and expressive emotions. Sudden encounter of a crush. They sing that it is not just a process to get the person to love you back, but their emotion itself is what is lovable and precious.\n" +
                    "\n" +
                    "Also, the news that one of the hippest artists in the world, Grimes, will be featuring in the track have raised a fervor in the pop scene around the globe. The beats lay on the start for the girls with blessing and grace by Grimes, the creator of her own musical universe.\n" +
                    "\n" +
                    "The music video was shot exclusively in Szabadkígyós, Hungary with LOONA's video director Digipedi. The director capture LOONA/yyxy's process of completing heir ego, which may be a 'new' 'Heart Attack' which is 'One & Only' and 'Egoist' in their own each way. "
        ),

        arrayOf(
            "frozen",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ yyxy")),
            "beauty&thebeat",
            "Hwang Hyun (MonoTree)",
            "Hwang Hyun (MonoTree)",
            "Hwang Hyun (MonoTree)",
            "Pop",
            208,
            R.drawable.cover_frozen,
            "https://open.spotify.com/track/5zNzvVBEuk8EEQslNTe42B?si=4gJvQZWHTj-yHLK3HACxEQ",
            "",
            "\"frozen\" aurally mesmerizes the audiences with oriental story-telling on top of a westernized beat. The melodies of the verse start in the spring passes through summer, where it reaches the chorus and hits you like winter, until flowers bloom again."
        ),

        arrayOf(
            "one way",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ yyxy")),
            "beauty&thebeat",
            "Darly, Kam Dong is (Park Ji Won)",
            "Kam Dong is (Park Ji Won), Seo Jae Ha, Kim Yeong Seong",
            "Kam Dong is (Park Ji Won), Seo Jae Ha, Kim Yeong Seong",
            "Ballad",
            227,
            R.drawable.cover_one_way,
            "https://open.spotify.com/track/0ZoFCxoLfn2uKunJbm4ERr?si=_g-JzCdQQre6ubPqJEGi4Q",
            "",
            "Yves opens with a dry voice as if she is standing alone in the silent desert, Chuu fils up the space with her voice full of moisture, Go Won's crunchy voice and Olivia Hye's voice with the duality of day and night, gather to complete one music."
        ),

        arrayOf(
            "rendezvous 18.6y",
            arrayOf(MemberRepository.getSubUnit("LOOΠΔ yyxy")),
            "beauty&thebeat",
            "G-high (MonoTree)",
            "G-high, Son Ko Eun (MonoTree)",
            "G-high, Son Ko Eun (MonoTree)",
            "Pop, Bossa Nova",
            206,
            R.drawable.cover_rendezvous_186y,
            "https://open.spotify.com/track/3jueKDWC9DmTfnU2jMxE8U?si=Mee-CAAVTruQBoxLH4RfnA",
            "",
            "18.6 years is the sidereal period of the coincidence of the girls becoming LOONA 1/3, YeoJin, LOONA/ODD EYE CIRCLE, and lastly LOONA/yyxy. And one fate. Meeting with Fan who have recognized LOONA from even before the debut. Endless things such as these that can only be described as 'rendezvous' That is how rendezvous 18.6y becomes meaningful. "
        )

    )

    fun all(): List<Song> = values.mapIndexed { index, dataItem ->
        initialize(index + 1, dataItem)
    }

    private fun initialize(id: Int, data: Array<Serializable>): Song = Song(
        id = id,
        title = data[0] as String,
        artists = initializeMembers(data[1] as Array<*>),
        album = data[2] as String,
        lyricists = data[3] as String,
        composers = data[4] as String,
        arrangers = data[5] as String,
        genres = data[6] as String,
        lengthInSeconds = data[7] as Int,
        coverArt = data[8] as Int,
        musicLink = data[9] as String,
        musicVideoLink = data[10] as String,
        description = data[11] as String
    )

    private fun initializeMembers(members: Array<*>): List<Artist> = members.map {
        when (it) {
            is Int -> MemberRepository.findById(it)!!
            else -> it as Artist
        }
    }

    fun findById(songId: Int): Song? {
        if (songId <= 0) {
            return null
        }

        return initialize(songId, values[songId - 1])
    }
}