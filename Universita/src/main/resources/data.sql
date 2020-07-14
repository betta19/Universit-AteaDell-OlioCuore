REPLACE INTO `roles` VALUES (1,'DOCENTE');
REPLACE INTO `roles` VALUES (2,'STUDENTE');
REPLACE INTO `universita`.`user` (`id`, `username`, `email` , `password`) VALUES ('1', 'pappa','pappa@pappa.it', '$2a$10$SkwU1ANf.fIySTiYSPHkPOZmENl0ZNoICuFbygqJPhyG4Si6vQ0Ha');
REPLACE INTO `universita`.`user_role` (`user_id`, `roles_id`) VALUES ('1', '1');
