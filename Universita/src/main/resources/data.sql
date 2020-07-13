REPLACE INTO `roles` VALUES (1,'DOCENTE');
REPLACE INTO `roles` VALUES (2,'STUDENTE');
REPLACE INTO `universita`.`docente` (`docente_id`, `email_docente`, `password_docente`, `username`) VALUES ('1', 'pappa@pappa.it', '$2a$10$SkwU1ANf.fIySTiYSPHkPOZmENl0ZNoICuFbygqJPhyG4Si6vQ0Ha', 'pappa');
REPLACE INTO `universita`.`docente_role` (`docente_id`, `role_id`) VALUES ('1', '1');
