memberSearchIndex = [{"p":"database.sql.commands","c":"Companies","l":"ADD_COMPANY"},{"p":"database.sql.commands","c":"Coupons","l":"ADD_COUPON"},{"p":"database.sql.commands","c":"Customers","l":"ADD_CUSTOMER"},{"p":"database.sql.commands","c":"Cvc","l":"ADD_CVC_STEP1"},{"p":"database.sql.commands","c":"Cvc","l":"ADD_CVC_STEP2"},{"p":"database.dao","c":"CompaniesDAO","l":"addCompany(Company)","u":"addCompany(beans.Company)"},{"p":"database.dbdao","c":"CompaniesDBDAO","l":"addCompany(Company)","u":"addCompany(beans.Company)"},{"p":"facade","c":"AdminFacade","l":"addCompany(Company)","u":"addCompany(beans.Company)"},{"p":"database.dao","c":"CouponDAO","l":"addCoupon(Coupon)","u":"addCoupon(beans.Coupon)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"addCoupon(Coupon)","u":"addCoupon(beans.Coupon)"},{"p":"facade","c":"CompanyFacade","l":"addCoupon(Coupon)","u":"addCoupon(beans.Coupon)"},{"p":"database.dao","c":"CouponDAO","l":"addCouponPurchase(int, int)","u":"addCouponPurchase(int,int)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"addCouponPurchase(int, int)","u":"addCouponPurchase(int,int)"},{"p":"database.dao","c":"CustomersDAO","l":"addCustomer(Customer)","u":"addCustomer(beans.Customer)"},{"p":"database.dbdao","c":"CustomerDBDAO","l":"addCustomer(Customer)","u":"addCustomer(beans.Customer)"},{"p":"facade","c":"AdminFacade","l":"addCustomer(Customer)","u":"addCustomer(beans.Customer)"},{"p":"facade","c":"AdminFacade","l":"AdminFacade(String, String)","u":"%3Cinit%3E(java.lang.String,java.lang.String)"},{"p":"beans","c":"ClientType","l":"Adminstrator"},{"p":"facade","c":"CustomerFacade","l":"buyCoupon(int)"},{"p":"database.sql.commands","c":"Categories","l":"Categories()","u":"%3Cinit%3E()"},{"p":"beans","c":"Client","l":"Client(Integer, String, String, List<Coupon>)","u":"%3Cinit%3E(java.lang.Integer,java.lang.String,java.lang.String,java.util.List)"},{"p":"facade","c":"ClientFacade","l":"ClientFacade(String, String)","u":"%3Cinit%3E(java.lang.String,java.lang.String)"},{"p":"exception","c":"ClientNotLoggedInException","l":"ClientNotLoggedInException(ClientType)","u":"%3Cinit%3E(beans.ClientType)"},{"p":"database.sql","c":"ConnectionPool","l":"closeAllConnections()"},{"p":"database.sql.commands","c":"Companies","l":"Companies()","u":"%3Cinit%3E()"},{"p":"facade","c":"ClientFacade","l":"companiesDBDAO"},{"p":"database.dbdao","c":"CompaniesDBDAO","l":"CompaniesDBDAO()","u":"%3Cinit%3E()"},{"p":"beans","c":"ClientType","l":"Company"},{"p":"exception","c":"SQLDuplicateUniqueKeyException.tables","l":"COMPANY"},{"p":"beans","c":"Company","l":"Company(Integer, String, String, String, List<Coupon>)","u":"%3Cinit%3E(java.lang.Integer,java.lang.String,java.lang.String,java.lang.String,java.util.List)"},{"p":"beans","c":"Company","l":"Company(String, String, String)","u":"%3Cinit%3E(java.lang.String,java.lang.String,java.lang.String)"},{"p":"facade","c":"CompanyFacade","l":"CompanyFacade(String, String)","u":"%3Cinit%3E(java.lang.String,java.lang.String)"},{"p":"database.dbdao","c":"DBDAOUtils","l":"companyToParams(Company)","u":"companyToParams(beans.Company)"},{"p":"exception","c":"SQLDuplicateUniqueKeyException.tables","l":"COUPON"},{"p":"beans","c":"Coupon","l":"Coupon(Integer, Category, String, String, Date, Date, Integer, Double, String)","u":"%3Cinit%3E(java.lang.Integer,beans.Category,java.lang.String,java.lang.String,java.sql.Date,java.sql.Date,java.lang.Integer,java.lang.Double,java.lang.String)"},{"p":"beans","c":"Coupon","l":"Coupon(Integer, Integer, Category, String, String, Date, Date, Integer, Double, String)","u":"%3Cinit%3E(java.lang.Integer,java.lang.Integer,beans.Category,java.lang.String,java.lang.String,java.sql.Date,java.sql.Date,java.lang.Integer,java.lang.Double,java.lang.String)"},{"p":"facade","c":"ClientFacade","l":"couponDBDAO"},{"p":"database.dbdao","c":"CouponDBDAO","l":"CouponDBDAO()","u":"%3Cinit%3E()"},{"p":"cls","c":"CouponExpirationDailyJob","l":"CouponExpirationDailyJob()","u":"%3Cinit%3E()"},{"p":"database.sql.commands","c":"Coupons","l":"Coupons()","u":"%3Cinit%3E()"},{"p":"database.dbdao","c":"DBDAOUtils","l":"couponToParams(Coupon)","u":"couponToParams(beans.Coupon)"},{"p":"database.sql.commands","c":"General","l":"CREATE_DB"},{"p":"database.sql.commands","c":"Categories","l":"CREATE_TABLE_CATEGORIES"},{"p":"database.sql.commands","c":"Companies","l":"CREATE_TABLE_COMPANIES"},{"p":"database.sql.commands","c":"Coupons","l":"CREATE_TABLE_COUPONS"},{"p":"database.sql.commands","c":"Customers","l":"CREATE_TABLE_CUSTOMERS"},{"p":"database.sql.commands","c":"Cvc","l":"CREATE_TABLE_CVC"},{"p":"beans","c":"ClientType","l":"Customer"},{"p":"exception","c":"SQLDuplicateUniqueKeyException.tables","l":"CUSTOMER"},{"p":"beans","c":"Customer","l":"Customer(Integer, String, String, String, String, List<Coupon>)","u":"%3Cinit%3E(java.lang.Integer,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.util.List)"},{"p":"beans","c":"Customer","l":"Customer(String, String, String, String)","u":"%3Cinit%3E(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"},{"p":"facade","c":"ClientFacade","l":"customerDBDAO"},{"p":"database.dbdao","c":"CustomerDBDAO","l":"CustomerDBDAO()","u":"%3Cinit%3E()"},{"p":"facade","c":"CustomerFacade","l":"CustomerFacade(String, String)","u":"%3Cinit%3E(java.lang.String,java.lang.String)"},{"p":"exception","c":"CustomerIsNotAdminException","l":"CustomerIsNotAdminException(String)","u":"%3Cinit%3E(java.lang.String)"},{"p":"database.sql.commands","c":"Customers","l":"Customers()","u":"%3Cinit%3E()"},{"p":"database.dbdao","c":"DBDAOUtils","l":"customerToParams(Customer)","u":"customerToParams(beans.Customer)"},{"p":"exception","c":"SQLDuplicateUniqueKeyException.tables","l":"CVC"},{"p":"database.sql.commands","c":"Cvc","l":"Cvc()","u":"%3Cinit%3E()"},{"p":"database.dbdao","c":"DBDAOUtils","l":"DBDAOUtils()","u":"%3Cinit%3E()"},{"p":"database.sql","c":"DBmanager","l":"DBmanager()","u":"%3Cinit%3E()"},{"p":"database.sql","c":"DButils","l":"DButils()","u":"%3Cinit%3E()"},{"p":"database.sql.commands","c":"Companies","l":"DELETE_COMPANY"},{"p":"database.sql.commands","c":"Coupons","l":"DELETE_COUPON"},{"p":"database.sql.commands","c":"Customers","l":"DELETE_CUSTOMER"},{"p":"database.sql.commands","c":"Cvc","l":"DELETE_CVC"},{"p":"database.sql.commands","c":"Coupons","l":"DELETE_EXPIRED_COUPON"},{"p":"database.dao","c":"CompaniesDAO","l":"deleteCompany(int)"},{"p":"database.dbdao","c":"CompaniesDBDAO","l":"deleteCompany(int)"},{"p":"facade","c":"AdminFacade","l":"deleteCompany(int)"},{"p":"facade","c":"CompanyFacade","l":"deleteCoupon(int)"},{"p":"database.dao","c":"CouponDAO","l":"deleteCoupon(int, int)","u":"deleteCoupon(int,int)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"deleteCoupon(int, int)","u":"deleteCoupon(int,int)"},{"p":"database.dao","c":"CouponDAO","l":"deleteCouponPurchase(int, int)","u":"deleteCouponPurchase(int,int)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"deleteCouponPurchase(int, int)","u":"deleteCouponPurchase(int,int)"},{"p":"database.dao","c":"CustomersDAO","l":"deleteCustomer(int)"},{"p":"database.dbdao","c":"CustomerDBDAO","l":"deleteCustomer(int)"},{"p":"facade","c":"AdminFacade","l":"deleteCustomer(int)"},{"p":"database.dao","c":"CouponDAO","l":"deleteExpiredCoupons()"},{"p":"database.dbdao","c":"CouponDBDAO","l":"deleteExpiredCoupons()"},{"p":"database.sql","c":"SQLExceptionErrorCodes","l":"DUPLICATE_KEY"},{"p":"beans","c":"Category","l":"Electricity"},{"p":"beans","c":"Category","l":"Food"},{"p":"beans","c":"Category","l":"Gaming"},{"p":"database.sql.commands","c":"General","l":"General()","u":"%3Cinit%3E()"},{"p":"database.sql.commands","c":"Companies","l":"GET_ALL_COMPANY"},{"p":"database.sql.commands","c":"Coupons","l":"GET_ALL_COUPON"},{"p":"database.sql.commands","c":"Coupons","l":"GET_ALL_COUPON_OF_COMPANY"},{"p":"database.sql.commands","c":"Coupons","l":"GET_ALL_COUPON_OF_COMPANY_BY_CATEGORY"},{"p":"database.sql.commands","c":"Coupons","l":"GET_ALL_COUPON_OF_COMPANY_UP_TO_PRICE"},{"p":"database.sql.commands","c":"Cvc","l":"GET_ALL_COUPON_OF_CUSTOMER"},{"p":"database.sql.commands","c":"Cvc","l":"GET_ALL_COUPON_OF_CUSTOMER_BY_CATEGORY"},{"p":"database.sql.commands","c":"Cvc","l":"GET_ALL_COUPON_OF_CUSTOMER_UP_TO_PRICE"},{"p":"database.sql.commands","c":"Customers","l":"GET_ALL_CUSTOMERS"},{"p":"database.sql.commands","c":"General","l":"GET_CLIENT_IN_TABLE(String)","u":"GET_CLIENT_IN_TABLE(java.lang.String)"},{"p":"database.sql.commands","c":"Companies","l":"GET_COMPANY"},{"p":"database.sql.commands","c":"Companies","l":"GET_COMPANY_WITH_COUPONS"},{"p":"database.sql.commands","c":"Companies","l":"GET_ONE_COMPANY"},{"p":"database.sql.commands","c":"Coupons","l":"GET_ONE_COUPON"},{"p":"database.sql.commands","c":"Customers","l":"GET_ONE_CUSTOMER"},{"p":"database.dao","c":"CompaniesDAO","l":"getAllCompanies()"},{"p":"database.dbdao","c":"CompaniesDBDAO","l":"getAllCompanies()"},{"p":"facade","c":"AdminFacade","l":"getAllCompanies()"},{"p":"database.dao","c":"CouponDAO","l":"getAllCoupons()"},{"p":"database.dbdao","c":"CouponDBDAO","l":"getAllCoupons()"},{"p":"facade","c":"CompanyFacade","l":"getAllCoupons()"},{"p":"facade","c":"CustomerFacade","l":"getAllCoupons()"},{"p":"facade","c":"CompanyFacade","l":"getAllCouponsByCategory(Category)","u":"getAllCouponsByCategory(beans.Category)"},{"p":"facade","c":"CustomerFacade","l":"getAllCouponsByCategory(Category)","u":"getAllCouponsByCategory(beans.Category)"},{"p":"facade","c":"CompanyFacade","l":"getAllCouponsByUpToPrice(double)"},{"p":"facade","c":"CustomerFacade","l":"getAllCouponsByUpToPrice(double)"},{"p":"database.dao","c":"CouponDAO","l":"getAllCouponsOfCompany(int)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"getAllCouponsOfCompany(int)"},{"p":"database.dao","c":"CouponDAO","l":"getAllCouponsOfCompanyByCategory(int, Category)","u":"getAllCouponsOfCompanyByCategory(int,beans.Category)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"getAllCouponsOfCompanyByCategory(int, Category)","u":"getAllCouponsOfCompanyByCategory(int,beans.Category)"},{"p":"database.dao","c":"CouponDAO","l":"getAllCouponsOfCompanyUpToPrice(int, double)","u":"getAllCouponsOfCompanyUpToPrice(int,double)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"getAllCouponsOfCompanyUpToPrice(int, double)","u":"getAllCouponsOfCompanyUpToPrice(int,double)"},{"p":"database.dao","c":"CouponDAO","l":"getAllCouponsOfCustomer(int)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"getAllCouponsOfCustomer(int)"},{"p":"database.dao","c":"CouponDAO","l":"getAllCouponsOfCustomerByCategory(int, Category)","u":"getAllCouponsOfCustomerByCategory(int,beans.Category)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"getAllCouponsOfCustomerByCategory(int, Category)","u":"getAllCouponsOfCustomerByCategory(int,beans.Category)"},{"p":"database.dao","c":"CouponDAO","l":"getAllCouponsOfCustomerUpToPrice(int, double)","u":"getAllCouponsOfCustomerUpToPrice(int,double)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"getAllCouponsOfCustomerUpToPrice(int, double)","u":"getAllCouponsOfCustomerUpToPrice(int,double)"},{"p":"database.dao","c":"CustomersDAO","l":"getAllCustomers()"},{"p":"database.dbdao","c":"CustomerDBDAO","l":"getAllCustomers()"},{"p":"facade","c":"AdminFacade","l":"getAllCustomers()"},{"p":"database.dao","c":"CompaniesDAO","l":"getClient(String, String)","u":"getClient(java.lang.String,java.lang.String)"},{"p":"database.dao","c":"CustomersDAO","l":"getClient(String, String)","u":"getClient(java.lang.String,java.lang.String)"},{"p":"database.dbdao","c":"CompaniesDBDAO","l":"getClient(String, String)","u":"getClient(java.lang.String,java.lang.String)"},{"p":"database.dbdao","c":"CustomerDBDAO","l":"getClient(String, String)","u":"getClient(java.lang.String,java.lang.String)"},{"p":"database.sql","c":"ConnectionPool","l":"getConnection()"},{"p":"facade","c":"CustomerFacade","l":"getCustomerDetails()"},{"p":"cls","c":"LoginManager","l":"getInstance()"},{"p":"database.sql","c":"ConnectionPool","l":"getInstance()"},{"p":"database.dao","c":"CompaniesDAO","l":"getOneCompany(int)"},{"p":"database.dbdao","c":"CompaniesDBDAO","l":"getOneCompany(int)"},{"p":"facade","c":"AdminFacade","l":"getOneCompany(int)"},{"p":"database.dao","c":"CouponDAO","l":"getOneCoupon(int)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"getOneCoupon(int)"},{"p":"database.dao","c":"CustomersDAO","l":"getOneCustomer(int)"},{"p":"database.dbdao","c":"CustomerDBDAO","l":"getOneCustomer(int)"},{"p":"facade","c":"AdminFacade","l":"getOneCustomer(int)"},{"p":"cls","c":"CouponExpirationDailyJob","l":"getQuit()"},{"p":"beans","c":"Category","l":"Healthcare"},{"p":"database.sql","c":"SQL_Init","l":"initSQL()"},{"p":"database.sql.commands","c":"Categories","l":"INSERT_CATEGORIES(int)"},{"p":"database.sql","c":"ConnectionPool","l":"instance"},{"p":"database.sql.commands","c":"General","l":"IS_EXISTS_IN_TABLE(String)","u":"IS_EXISTS_IN_TABLE(java.lang.String)"},{"p":"database.dao","c":"CompaniesDAO","l":"isCompanyExists(String, String)","u":"isCompanyExists(java.lang.String,java.lang.String)"},{"p":"database.dbdao","c":"CompaniesDBDAO","l":"isCompanyExists(String, String)","u":"isCompanyExists(java.lang.String,java.lang.String)"},{"p":"database.dao","c":"CustomersDAO","l":"isCustomerExists(String, String)","u":"isCustomerExists(java.lang.String,java.lang.String)"},{"p":"database.dbdao","c":"CustomerDBDAO","l":"isCustomerExists(String, String)","u":"isCustomerExists(java.lang.String,java.lang.String)"},{"p":"facade","c":"AdminFacade","l":"login(String, String)","u":"login(java.lang.String,java.lang.String)"},{"p":"facade","c":"ClientFacade","l":"login(String, String)","u":"login(java.lang.String,java.lang.String)"},{"p":"facade","c":"CompanyFacade","l":"login(String, String)","u":"login(java.lang.String,java.lang.String)"},{"p":"facade","c":"CustomerFacade","l":"login(String, String)","u":"login(java.lang.String,java.lang.String)"},{"p":"cls","c":"LoginManager","l":"login(String, String, ClientType)","u":"login(java.lang.String,java.lang.String,beans.ClientType)"},{"p":"<Unnamed>","c":"Main","l":"Main()","u":"%3Cinit%3E()"},{"p":"<Unnamed>","c":"Main","l":"main(String[])","u":"main(java.lang.String[])"},{"p":"exception","c":"ObjectNotFoundException","l":"ObjectNotFoundException(int, String)","u":"%3Cinit%3E(int,java.lang.String)"},{"p":"exception","c":"ObjectNotFoundException","l":"ObjectNotFoundException(String)","u":"%3Cinit%3E(java.lang.String)"},{"p":"exception","c":"OutOfStockException","l":"OutOfStockException(int)","u":"%3Cinit%3E(int)"},{"p":"beans","c":"QueryResult","l":"QueryResult()","u":"%3Cinit%3E()"},{"p":"beans","c":"Category","l":"Restaurant"},{"p":"database.sql","c":"ConnectionPool","l":"restoreConnection(Connection)","u":"restoreConnection(java.sql.Connection)"},{"p":"database.dbdao","c":"DBDAOUtils","l":"resultSetToCompany(ResultSet)","u":"resultSetToCompany(java.sql.ResultSet)"},{"p":"database.dbdao","c":"DBDAOUtils","l":"resultSetToCoupon(ResultSet)","u":"resultSetToCoupon(java.sql.ResultSet)"},{"p":"database.dbdao","c":"DBDAOUtils","l":"resultSetToCouponOfCompanies(ResultSet)","u":"resultSetToCouponOfCompanies(java.sql.ResultSet)"},{"p":"database.dbdao","c":"DBDAOUtils","l":"resultSetToCustomer(ResultSet)","u":"resultSetToCustomer(java.sql.ResultSet)"},{"p":"facade","c":"CompanyFacade","l":"returnCompanyDetails()"},{"p":"cls","c":"CouponExpirationDailyJob","l":"run()"},{"p":"database.sql","c":"DButils","l":"runQuery(String)","u":"runQuery(java.lang.String)"},{"p":"database.sql","c":"DButils","l":"runQuery(String, Map<Integer, Object>)","u":"runQuery(java.lang.String,java.util.Map)"},{"p":"database.sql","c":"DButils","l":"runQueryForResult(String)","u":"runQueryForResult(java.lang.String)"},{"p":"database.sql","c":"DButils","l":"runQueryForResult(String, Map<Integer, Object>)","u":"runQueryForResult(java.lang.String,java.util.Map)"},{"p":"cls","c":"CouponExpirationDailyJob","l":"setQuit(Boolean)","u":"setQuit(java.lang.Boolean)"},{"p":"database.sql","c":"DBmanager","l":"SQL_ADMIN_EMAIL"},{"p":"database.sql","c":"DBmanager","l":"SQL_ADMIN_PASSWORD"},{"p":"database.sql","c":"DBmanager","l":"SQL_CATEGORIES"},{"p":"database.sql","c":"DBmanager","l":"SQL_COMPANIES"},{"p":"database.sql","c":"DBmanager","l":"SQL_COUPONS"},{"p":"database.sql","c":"DBmanager","l":"SQL_CUSTOMERS"},{"p":"database.sql","c":"DBmanager","l":"SQL_CVC"},{"p":"database.sql","c":"DBmanager","l":"SQL_DB"},{"p":"database.sql","c":"SQL_Init","l":"SQL_Init()","u":"%3Cinit%3E()"},{"p":"database.sql","c":"DBmanager","l":"SQL_PASSWORD"},{"p":"database.sql","c":"DBmanager","l":"SQL_USER"},{"p":"exception","c":"SQLDuplicateUniqueKeyException","l":"SQLDuplicateUniqueKeyException(SQLDuplicateUniqueKeyException.tables)","u":"%3Cinit%3E(exception.SQLDuplicateUniqueKeyException.tables)"},{"p":"database.sql","c":"SQLExceptionErrorCodes","l":"SQLExceptionErrorCodes()","u":"%3Cinit%3E()"},{"p":"cls","c":"CouponExpirationDailyJob","l":"stop()"},{"p":"cls","c":"Test","l":"Test()","u":"%3Cinit%3E()"},{"p":"cls","c":"Test","l":"testAll()"},{"p":"beans","c":"Company","l":"toString()"},{"p":"beans","c":"Coupon","l":"toString()"},{"p":"beans","c":"Customer","l":"toString()"},{"p":"database.sql.commands","c":"Companies","l":"UPDATE_COMPANY"},{"p":"database.sql.commands","c":"Coupons","l":"UPDATE_COUPON"},{"p":"database.sql.commands","c":"Customers","l":"UPDATE_CUSTOMER"},{"p":"database.dao","c":"CompaniesDAO","l":"updateCompany(Company)","u":"updateCompany(beans.Company)"},{"p":"database.dbdao","c":"CompaniesDBDAO","l":"updateCompany(Company)","u":"updateCompany(beans.Company)"},{"p":"facade","c":"AdminFacade","l":"updateCompany(Company)","u":"updateCompany(beans.Company)"},{"p":"database.dao","c":"CouponDAO","l":"updateCoupon(Coupon)","u":"updateCoupon(beans.Coupon)"},{"p":"database.dbdao","c":"CouponDBDAO","l":"updateCoupon(Coupon)","u":"updateCoupon(beans.Coupon)"},{"p":"facade","c":"CompanyFacade","l":"updateCoupon(Coupon)","u":"updateCoupon(beans.Coupon)"},{"p":"database.dao","c":"CustomersDAO","l":"updateCustomer(Customer)","u":"updateCustomer(beans.Customer)"},{"p":"database.dbdao","c":"CustomerDBDAO","l":"updateCustomer(Customer)","u":"updateCustomer(beans.Customer)"},{"p":"facade","c":"AdminFacade","l":"updateCustomer(Customer)","u":"updateCustomer(beans.Customer)"},{"p":"database.sql","c":"DBmanager","l":"URL"},{"p":"beans","c":"Category","l":"Vacation"},{"p":"database.sql.commands","c":"Cvc","l":"VALIDATE_OUT_OF_STOCK"},{"p":"beans","c":"Category","l":"valueOf(String)","u":"valueOf(java.lang.String)"},{"p":"beans","c":"ClientType","l":"valueOf(String)","u":"valueOf(java.lang.String)"},{"p":"exception","c":"SQLDuplicateUniqueKeyException.tables","l":"valueOf(String)","u":"valueOf(java.lang.String)"},{"p":"beans","c":"Category","l":"values()"},{"p":"beans","c":"ClientType","l":"values()"},{"p":"exception","c":"SQLDuplicateUniqueKeyException.tables","l":"values()"}];updateSearchResults();