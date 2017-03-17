CREATE TABLE `Product` (
  `product_id` 	varchar(20) NOT NULL,
  `P_G_price` 		int(10) DEFAULT NULL,
  `Name` 		varchar(60) DEFAULT NULL,
  `AVG_cost` 	numeric(12,4) DEFAULT NULL,
  `O_place` 	varchar(20) DEFAULT NULL,
  `S_life` 		    int(10) DEFAULT NULL,
  `Suppier_id` 	    char(4) DEFAULT NULL,
  `fileName`   varchar (60) DEFAULT NULL,
  `productImage`     longblob     DEFAULT NULL,
  
	CONSTRAINT Product_product_id_PK PRIMARY KEY (`product_Id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `Taste` (
  `Taste_id` 	varchar(4) NOT NULL,
  `Taste_Name` 	varchar(60) DEFAULT NULL,
  
	CONSTRAINT Taste_Taste_id_PK PRIMARY KEY (`Taste_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE `Package` (
  `Package_id` 	    varchar(20) NOT NULL,
  `Description` 	varchar(60) DEFAULT NULL,

  
	CONSTRAINT Package_Package_id_PK PRIMARY KEY (`Package_Id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `Product_Taste_Package` (
  `Product_id` 	    varchar(20) NOT NULL,
  `Taste_id` 	    varchar(4)  NOT NULL,
  `Package_id` 	    varchar(20) NOT NULL,
  
	CONSTRAINT P_T_P_Product_id_FK FOREIGN KEY (Product_id) 
		REFERENCES Product(Product_id),
	CONSTRAINT P_T_P_Taste_id_FK FOREIGN KEY (Taste_id) 
		REFERENCES Taste(Taste_id),
	CONSTRAINT P_T_P_Package_id_FK FOREIGN KEY (Package_id) 
		REFERENCES Package(Package_id),
	CONSTRAINT P_T_P_P_T_P_id_PK PRIMARY KEY (Product_id,Taste_id,Package_id)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `Composition` (
  `Com_type`            char(1) NOT NULL,
  `Com_id` 	         varchar(4) NOT NULL,
  `Com_description` varchar(60) DEFAULT NULL,
  
	CONSTRAINT Composition_Com_id_PK PRIMARY KEY (`Com_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `Supplier` (
  `Supplier_id`        char(4) NOT NULL,
  `Name` 	        varchar(60) DEFAULT NULL,
  `Telephone` 		varchar(30) DEFAULT NULL,
  `ZipNo` 			   char(6) DEFAULT NULL,
  `Address` 		varchar(100) DEFAULT NULL,
  `Fax` 			varchar(14) DEFAULT NULL,
  `Email` 			varchar(60) DEFAULT NULL,
  `URL` 			varchar(100) DEFAULT NULL,
  `Principal_Name` 	varchar(30) DEFAULT NULL,
  `Contact_Name` 	varchar(30) DEFAULT NULL,
  
	CONSTRAINT Supplier_Supplier_id_PK PRIMARY KEY (`Supplier_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE `Customer` (
  `Customer_id`         char(4) NOT NULL,
  `Simple_Name` 	 varchar(10) DEFAULT NULL,
  `Name` 			 varchar(60) DEFAULT NULL,
  `Sale_Path` 			char(1) DEFAULT NULL,
  `Telephone` 		 varchar(30) DEFAULT NULL,
  `Fax` 			 varchar(30) DEFAULT NULL,
  `Contacter` 		 varchar(30) DEFAULT NULL,
  `Address` 			 varchar(30) DEFAULT NULL,
  `Uniform_NO` 		    char(8) DEFAULT NULL,
  `This_Invertory_Date`	char(10) DEFAULT NULL,
  `Last_Invertory_Date`	char(10) DEFAULT NULL,
  `PR_Status`	        char(1) DEFAULT NULL,
  `Current_Discount_id`	char(2) DEFAULT NULL,
  `Next_Discount_id`	char(2) DEFAULT NULL,
  `Tax_Type` 		    char(1) DEFAULT NULL,
  `URL` 			 varchar(100) DEFAULT NULL,
  `Principal_Name` 	 varchar(30) DEFAULT NULL,
  `Contact_Name` 	 varchar(30) DEFAULT NULL,
  `Email` 			 varchar(60) DEFAULT NULL,
  `Line` 	         varchar(30) DEFAULT NULL,
  `Skype` 			 varchar(30) DEFAULT NULL,
	
   CONSTRAINT Customer_Customer_id_PK PRIMARY KEY (`Customer_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Discount(
	Discount_ID     INT AUTO_INCREMENT NOT NULL,
	description		NUMERIC (6,4),
	
	CONSTRAINT Discount_Discount_ID_PK PRIMARY KEY (Discount_ID)
);


CREATE TABLE Commission(

	Commission_ID 	INT AUTO_INCREMENT NOT NULL,
	Customer_id 	CHAR(4),
	Discount_01		NUMERIC (6,4),
	Discount_02		NUMERIC (6,4),
	Discount_03		NUMERIC (6,4),
	Discount_04		NUMERIC (6,4),
	Discount_05		NUMERIC (6,4),
	Discount_06		NUMERIC (6,4),
	Discount_07		NUMERIC (6,4),
	Discount_08		NUMERIC (6,4),
	Discount_09		NUMERIC (6,4),
	Discount_10		NUMERIC (6,4),
	Rate_01			NUMERIC (6,4),
	Rate_02			NUMERIC (6,4),
	Rate_03			NUMERIC (6,4),
	Rate_04			NUMERIC (6,4),
	Rate_05			NUMERIC (6,4),
	Rate_06			NUMERIC (6,4),
	Rate_07			NUMERIC (6,4),
	Rate_08			NUMERIC (6,4),
	Rate_09			NUMERIC (6,4),
	Rate_10			NUMERIC (6,4),
	
	CONSTRAINT Commission_Customer_ID_FK FOREIGN KEY (Customer_id) 
		REFERENCES Customer(Customer_id) ,
	CONSTRAINT Commission_Commission_ID_PK PRIMARY KEY (Commission_ID)
	
)CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE Warehouse(
	
	W_ID 			INT AUTO_INCREMENT NOT NULL,
	Customer_id		CHAR(4),		
	Product_id		VARCHAR(20),
	Taste_ID		VARCHAR(20),
	Package_ID		VARCHAR(20),
	Stock			INT,			
	AC_REC			INT,			
	AC_RET			INT,			
	AC_SAL			INT,			
	AC_BAD			INT,			
	AC_BAL 			INT,
	MFD 			DATE,
	
	CONSTRAINT Warehouse_Customer_ID_FK FOREIGN KEY (Customer_id) 
		REFERENCES Customer(Customer_id) ,
	CONSTRAINT Warehouse_Product_id_FK FOREIGN KEY (Product_id) 
		REFERENCES `Product`(`Product_id`), 
	CONSTRAINT Warehouse_Taste_ID_FK FOREIGN KEY (Taste_ID) 
		REFERENCES `Taste`(`Taste_ID`), 
	CONSTRAINT Warehouse_Package_ID_FK FOREIGN KEY (Package_ID) 
		REFERENCES `Package`(`Package_ID`),
	CONSTRAINT Warehouse_W_ID_PK PRIMARY KEY (W_ID)

)CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE `Member`(

			
	M_Username		VARCHAR(20) NOT NULL,
	M_Password		VARCHAR(60) NOT NULL,
	M_Name			VARCHAR(20) NOT NULL,
	M_Cellphone		VARCHAR(20) NOT NULL,
	M_Birthday		DATE NOT NULL,
	M_Insertdate	DATETIME,
	M_Updatedate	DATETIME,
	M_Level			CHAR(1) default 0,		
	M_BonusPoints	INT,					
	M_Total			NUMERIC(15,2),			
	
	CONSTRAINT Member_M_Username PRIMARY KEY (M_Username)
	
)	CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE StockUpdate(
	
	CP_ID			INT AUTO_INCREMENT NOT NULL,
	CP_Date			DATETIME,
	CP_REC			INT,			
	CP_RET			INT,			
	CP_SAL			INT,			
	CP_BAD			INT,			
	CP_BAL 			INT,			
	End_Stock		INT,			
	Net_Stock       INT,
	
	CONSTRAINT StockUpdate_CP_ID_PK PRIMARY KEY (CP_ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE TRHD(

	CO_SEQ			CHAR(4) NOT NULL,
	CO_Type 		CHAR(2) NOT NULL,
	CO_Role 		CHAR(4) NOT NULL,
	CO_Year			CHAR(1) NOT NULL,
	CO_Month		CHAR(1) NOT NULL,
	MIN_Role		CHAR(4),
	TR_Date			DATETIME,
	
	SEQ_NO			INT,	
	TO_QTY			INT,
	TO_List			NUMERIC (15,2),
	TO_Price		NUMERIC (15,2),
	TO_Sold			NUMERIC (15,2),
	TO_Cost			NUMERIC (15,2),
	TO_Disc			NUMERIC	(6,4),
	
	CONSTRAINT TRHD_PK PRIMARY KEY (CO_SEQ, CO_Type, 
								CO_Role, CO_Year, CO_Month)
								
)CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE TRDT(

	CO_SEQ			CHAR(4) NOT NULL,
	CO_Type 		CHAR(2) NOT NULL,
	CO_Role 		CHAR(4) NOT NULL,
	CO_Year			CHAR(1) NOT NULL,
	CO_Month		CHAR(1) NOT NULL,
	MIN_Role		CHAR(4),
	TR_Date			DATETIME,
	
	Product_id		VARCHAR(20),
	Taste_ID		VARCHAR(20),
	Package_ID		VARCHAR(20),
	SEQ_NO			INT,	
	TR_QTY			INT,
	TR_List			NUMERIC (15,2),
	TR_Price		NUMERIC (15,2),
	TR_Sold			NUMERIC (15,2),
	TR_Cost			NUMERIC (15,2),
	TR_Discount		NUMERIC	(6,4),
	

	Pre_Deposit		NUMERIC (15,2),
	This_Deposit	NUMERIC (15,2),
	VISA			NUMERIC (15,2),
	Cash			NUMERIC (15,2),
	Sales			CHAR(1),
	Shift			CHAR(1),
	Disc_AMT		NUMERIC (15,2),
	M_Username		VARCHAR(20),
	
	IUser			VARCHAR(20),
	IDate			DATE,
	ITime			DATETIME,
	MUser			VARCHAR(20),
	MDate			DATE,
	MTime			DATETIME,
	
	CONSTRAINT TRDT_M_Username_FK FOREIGN KEY (M_Username) 
		REFERENCES Member(M_Username),
	CONSTRAINT TRDT_Product_id_FK FOREIGN KEY (Product_id) 
		REFERENCES `Product`(`Product_id`), 
	CONSTRAINT TRDT_Taste_ID_FK FOREIGN KEY (Taste_ID) 
		REFERENCES `Taste`(`Taste_ID`), 
	CONSTRAINT TRDT_Package_ID_FK FOREIGN KEY (Package_ID) 
		REFERENCES `Package`(`Package_ID`),
	CONSTRAINT TRDT_PK PRIMARY KEY (CO_SEQ, CO_Type, 
								CO_Role, CO_Year, CO_Month)

	
)CHARACTER SET utf8 COLLATE utf8_general_ci;





CREATE TABLE `User`(
	userId 			VARCHAR(20) NOT NULL,
	password		VARCHAR(20) NOT NULL,
	name 			VARCHAR(20) NOT NULL,
	grade			VARCHAR(4) NOT NULL,
	
	CONSTRAINT User_userId PRIMARY KEY (userId)
	
)	CHARACTER SET utf8 COLLATE utf8_general_ci;