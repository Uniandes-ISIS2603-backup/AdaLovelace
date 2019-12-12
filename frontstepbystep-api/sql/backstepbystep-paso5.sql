delete from ReviewEntity;
delete from BookEntity_AuthorEntity;
delete from AuthorEntity;
delete from BookEntity;
delete from EditorialEntity;

insert into EditorialEntity (id, name) values (100,'Oveja Negra');
insert into EditorialEntity (id, name) values (200,'Siruela');

insert into BookEntity (id, name, isbn, image, description, publishDate, editorial_id) values (100, 'The Lord of the Rings', '930330149-8', 'https://images-na.ssl-images-amazon.com/images/I/516GyHY9p6L.jpg', 'Supplement R Tympanic Membrane with Synth Sub, Via Opening', '8/20/1996',100);
insert into BookEntity (id, name, isbn, image, description, publishDate, editorial_id) values (200, 'Harry Potter and the Sorcerer´s Stone', '507119915-7', 'http://m.cdn.blog.hu/ko/kockagyar/image/harry_potter_poster/harry_potter_1.jpg', 'Occlusion of Right Femoral Artery, Percutaneous Approach', '2/19/2014',100);
insert into BookEntity (id, name, isbn, image, description, publishDate, editorial_id) values (300, 'A Game of Thrones', '279453624-9', 'https://cdn.waterstones.com/bookjackets/large/9780/0075/9780007548231.jpg', 'Removal of Spacer from T-lum Jt, Perc Approach', '4/7/1998',100);
insert into BookEntity (id, name, isbn, image, description, publishDate, editorial_id) values (400, 'The Winds of Winter', '744706866-7', 'http://www.darkmediaonline.com/wp-content/uploads/2013/01/WindsofWinter.jpg', 'Reposition Left Femoral Shaft, Perc Endo Approach', '10/10/1998',200);
insert into BookEntity (id, name, isbn, image, description, publishDate, editorial_id) values (500, 'The Slow Regard of Silent Things', '260760424-9', 'http://www.patrickrothfuss.com/images/page/cover-slow-regard_277.jpg', 'Supplement Lower Artery with Autol Sub, Perc Approach', '5/9/2013',200);
insert into BookEntity (id, name, isbn, image, description, publishDate, editorial_id) values (600, 'Harry Potter and the Philosopher´s Stone', '260760424-9', 'https://katemacdonalddotnet.files.wordpress.com/2015/11/potter-1-4.jpg', 'disse accumsan tortor quis turp Perc Approach', '5/9/2013',200);

insert into AuthorEntity (id, name,  image, birthDate, description) values (100,'J.K. Rowling', 'http://cdn1us.denofgeek.com/sites/denofgeekus/files/2016/11/rowling.jpg', '4/7/1965','Joanne  Rowling, OBE, FRSL, pen names J. K. Rowling and Robert Galbraith, is a British novelist, screenwriter and film producer best known as the author of the Harry Potter fantasy series.');
insert into AuthorEntity (id, name,  image, birthDate, description) values (200, 'J. R. R. Tolkien', 'http://www.biografiasyvidas.com/biografia/t/fotos/tolkien.jpg', '01/03/1892','Joanne  Rowling, OBE, FRSL, pen names J. K. Rowling and Robert Galbraith, is a British novelist, screenwriter and film producer best known as the author of the Harry Potter fantasy series.');
insert into AuthorEntity (id, name,  image, birthDate, description) values (300, 'George R. R. Martin','http://static1.businessinsider.com/image/54d3c832eab8eabe028b4569-960/george-rr-martin-2011.jpg','09/20/1948', 'asA smkcxm slklkc n names J. K. Rowling and Robert Galbraith, is a British novelist');
insert into AuthorEntity (id, name,  image, birthDate, description) values (400,'Patrick Rothfuss','http://librista.es/blog/wp-content/uploads/2014/05/patrick-rothfuss.jpg/5x10','06/06/1973','Joanne  Rowling, OBE, FRSL, pen names J. K. Rowling and Robert Galbraith, is a British novelist, screenwriter and film producer best known as the author of the Harry Potter fantasy series.');

insert into BookEntity_AuthorEntity (books_id,authors_id ) values (100,200);
insert into BookEntity_AuthorEntity (books_id,authors_id ) values (200,100); 
insert into BookEntity_AuthorEntity (books_id,authors_id ) values (300,300);
insert into BookEntity_AuthorEntity (books_id,authors_id ) values (400,300); 
insert into BookEntity_AuthorEntity (books_id,authors_id ) values (500,400);   
insert into BookEntity_AuthorEntity (books_id,authors_id ) values (600,100);      

insert into ReviewEntity  (id, name,  description, source, book_id) values (100,' ', 'This isnot really like other books, even its imitators, though the best of them are similarly long, variable in pace and diverse in language and location. The early part of the story was meant to be a follow-up  ', ' ', 100);
insert into ReviewEntity  (id, name,  description, source, book_id) values (200, ' ','The trilogy is worth reading once. For readers who like fast paced action , this is not a series I would recommend. It progresses quite slowly and the descriptions are lengthy - not really my type. But if you have the patience, the plot is worth it.', ' ', 100);
insert into ReviewEntity  (id, name,  description, source, book_id) values (300,' ','This isnt really like other books, even its imitators, though the best of them are similarly long, variable in pace and diverse in language and location. The early part of the story was meant to be a follow-up to The Hobbit, u ',' ', 200);
insert into ReviewEntity  (id, name,  description, source, book_id) values (400,' ', 'The trilogy is worth reading once. For readers who like fast paced action , this is not a series I would recommend. It progresses quite slowly and the descriptions are lengthy - not really my type. But if you have the patience, the plot is worth it.',' ', 300);

private String name;
    private String isbn;
    private String image;
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    private String description;

    private Integer availability;
    private Integer totRatings;
    private Integer sumRating;
    private Double avgRating;
    private String comments;
    private Double discount;
    private String genre;

insert into BookEntity ( name, isbn, image, publishDate, description, availability, totRatings, sumRating, avgRating, comments, discount, genre)
values ('prueba1', '111', 'algo.png', '2020-10-10', 'alguna descripcion', 10, 0, 0, 0, 'algun comentario', 20, 'algun genero')

SELECT * FROM BookEntity

delete from bookentity




INSERT INTO BookEntity (id, name, isbn, description, image, publishDate, author, genre, availability, totRatings, sumRating, avgRating, comments, discount, editorial) values(9990,'The Mambo Kings Play Songs of Love','140143912','AHTPUOSN6O7CJQW0IOJV525LCUPO3RGTV8OH1YI5ZF10NRGF6EWIIAUTE3GZ0K5N5B91DGBTY60UDLKV8XIX12WO57ICRDXB1PUZUHS7Z9NYT1JC0PZ9A4RDO03E89DXV420BND0JY6KTKL6XFWYWHQGVU4XP0O45GYKYJ13LLCHHWDH9Q6WLFLYHYZE9OC2FVL6Y39UFNG3N2U0YXMMDL1JJN6JZKHW3V3T9C194N8LO4R2L19C0165ML8JBB5YBZ8JFEZYGWKOD5EFBLLAKSWQ8RP6CASGEUCXO115GU87LXI7BKLHC3PUEZZEQDC3ZEPGO7K5IH4NLVBJIR3JJ6SQU3MYG70KTTAOM2T1FK1DPDNSUW7450Q403XY77E32L5WEQ3QG6FD7MPKA4LPSTTUMZZOLNE7EVYKVEQ59IX21UPC60DLXTI86VXG9SFG4PGD3E0Y6TIWPDDC10IME5F2CNOL9CKAA25TZ9IU6G7S4P4HLNDS2K5VJQEYMB9G8ZCB0UPZ6FGA1PXQAZARE29GUJDC42MFC1JML8YFUKEZHI5CVYIS80T4QP3CSB5NQHEC9QJBVFKP9MBK0BPX7E8GVY3U0LOWNDPEMM7YIGQ6NH8BZF0VGZ9KQMA0ADCAMRBFBDOIFQMCRUUF8GHP8O6U3799C70VIIWQHQNVN5S5AH613YNIPUOYYOJA785V17TMVN96IX56N0QQ59DKX4W2ZR2R9GAAFIFD512NIFTRSI5BDL15WVDO919SJY74YGMBNPJ23XO47OX06M3HIHPJ8ZQLABFEQKFZGUHA57FNX5JOOEWQGXY735V16CYFYR83QERRCSPZJKPR1IQNL7APATVEUTTHW4LI3L9LGUB9UZWB6H9F6208ELA592L8JRWGSVN8PU4F1LAZH947F2VW5CJ42R2S8J4WOG758GDGQL9WBJ2S4SI38NG2M08AR9NJVZA3E06G9DRSBSSL91LLFVE0ODFM8HDEU5G7RR5Y1DJIS09V27CT28OVEZN5ITK6EE24ZUB8CNSA3VG74LO0LV3K5CFE2IU56OVZXUM6BGMF5U377E0NP1UMUOIWPCZ64ITTW8LYIJU4BSHUU7QHACS1NZEBN4AGC9QPRUS8AHFDYOW035I5WRFWS43VBTHOSAFV79Y2V8KHN1HL6DDOSV4LDCB1BDG230HL7JIP64W3N40VD45S9XJQNW181YYM4WR4HH6U5LHOT755GV3FAUNMX9XMFUWXTVKUBNZ1DPI5LH2ZP3NXM9T2BODWR49C7K4KYOUMQJ4QFARKOA6TA9DIRWM1VNIYNAMGW2ZD4SQ87A9QT93X8YX90095094LXMEGWM2V6IO94CJ051F00GGHLCXISG1DM5L3TJ8UYXT4DS3O2J6EIPHB1REY17D3EI68ERZDTBRA1HR579IIF3QXWKP9DBRU80733R988IVL1S2J2HXQGI5Q2J2DU9L7ZBMY9E16KAF3Q0WFDONET8Q3MHC1YV4KU17Y6HXEW563V1CV9AL22AV1WNE5Y2BISEU4U9BCWUA79QLOBCD5X7MKLXW50K2B2N2D4RFYVO8FHCM2MCHAAFT6W58O62QBKZ58C2Q2JYCJMX714HB6IMLPR181MW7E2PO92NVDOLMDMVTSUF1E95D9WETNRI5IOG22HG9FDDETQ78PBX5ARMINDQG56Z630QFIGPQ6ZUNF4MMVF810P1LU1C9C3MOKTQHQSA5TQ3JUHJE5ED0UTI0HXKYTKR6NT7GJEAEV6PAC1HESKU8BPZV5EZDAERTOC9A2HS4ON4CZWSWE7H9NR0NSK55B49HVH82CXDSQJM8YWNC8HKO1P5TSVOF0J13GN8VOJSGP1ZSA3Q36PU79S6VC3RTCS4DWZHSS23PAE3T90B2FN2KV0WWPHL8OJX4JK9C1QRK8S03NWQC4Z2YDLUM7MGJ56V361D5AP33XPPQFXLKT6GLYU2SA81Y9IC6AP477P6MT8I671FU3JZBXD90K83QR3XXHSW3RTP2WUPQ3N41ACTXRQYPVF6C4EE0DPDEV5SZFAAB07AI7XIIM3YGJQ1ZXP2MQYY7T1LCCFRZ6UWTH8KWLXA7EVL8117JHFJ78UCV0MLD61MY4URDW90EW1DGZWY7RV3Z4O1BAFS3PX3DAWPK6I11LF67SMOI97GTZIFO0GIN42EN654ONYSFN0G2ZI9TCLKLMLZNUIJZFU1SMZKE12R4CL94B62CPPDBV88HAK2ILU0DWRCK62GECMROWFQ59IOSDPSNFKA7ROZH8IMQJ2QHWKY2NGM7GUCCNHTT2Q6TSOMZKEP6N62QZZHOUXR1GOUFIXR5FE48NMCZM350WXO6IU1WADYF0BM8FQZKL3R2ILI9I7LO5IV6B6EYFP8T1R8TRUTXVSUCXIZH4S8V67I2V1RYX5IMVDBL9TOYKWNMC8EF4KW9JLSTE1I49IJ5I85YMP14P7O6OTMV7222QU0RAWX2NRKK44DUWJ8Z4Q88FGK21I5BGO9Y4KTPLI6U8VBCFVBMTIVBLJ9903ADT19FEDKKWRD1V03GZWQY1DAVOF7TLUWXJM8IMZI931QC62PIIXV0RBIXNRA052JOXLGBFBV2PYVI65N6RSVJTK5AWPTNPHYQ3XH6OOZH5TOY6TY8PTLE11L0145NU41SEO30O5FZTUW2QW6HFAX09KWZLQ1H4P50CSA7UHN8HQDGZ5F6OXZFTH2V3ZD48L2JAG9RCIFKRPJTXH5OB7REF0YED1MAYLAPL6FHW2DHF5351UKV7ACEQFOVS82J8ZD3TON7961AN4FLJW8CNC77W13QCLG5W0HC8BXXCQHB4DF61FBYF7HUQ7GD1BI502WM75WBD0X9CRM0964UEG6DPSNA6VJEYQG4KX3BTLTYTD9M0T4CAWR3IJCQKHZBI76Q2ILRRUER2PEG42L5LR16J522TC9WXCMO31JDINHDFLX97PRZIGC2NFME1OQ5OJJG2','https://images.gr-assets.com/books/1330072994m/294081.jpg','1989-01-01','Oscar Hijuelos','Children','16',0,0,0,'Sin comentarios',24,'Salamandra')

