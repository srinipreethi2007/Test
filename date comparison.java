def ACT_kpDisabledDate = context.expand( '${LDAPProperties#kpDisabledDate}' )
def todate = new Date().format('yyyyMMddHHmmS').toString()
def PDate = Date.parse('yyyyMMddHHmmSSS', ACT_kpDisabledDate)
def tdate = Date.parse('yyyyMMddHHmmSSS',todate )
//PDate.format('yyyyMMddHHmmSSS')
log.info PDate
log.info todate
log.info ACT_kpDisabledDate
assert PDate.compareTo(tdate) <= 1, "Difference is > 1"
log.info "assertion completed"

//UDS date comparison
def EXP_GUID = context.expand( '${#Project#CurrentGUID}' )
def ACT_kpGUID = context.expand( '${LDAPProperties#kpGUID}' )
assert ACT_kpGUID == EXP_GUID, "GUID matching"

def EXP_code = context.expand( '${DataSourceGen2#Code}' )
def ACT_code = context.expand( '${LDAPProperties#value}' )
assert ACT_code == EXP_code, "code is not matching"

def ACT_activationDate = context.expand( '${LDAPProperties#activationDate}' )
def ADate = Date.parse('yyyyMMddHHmmSSS', ACT_activationDate)
def EXP_ActivationDate = context.expand( '${DataSourceGen#Name}' )
def EDate = Date.parse('yyyy-MM-dd', EXP_ActivationDate)
assert ADate.compareTo(EDate)<= 0, "Date not matching"
log.info "assertion completed"