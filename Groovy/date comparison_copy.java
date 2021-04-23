//To check system vs field date
import java.lang.Object
import java.time.*
import java.text.DateFormat
import java.text.SimpleDateFormat

DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss.sss")//20201015111554.595Z
Date date = df.parse(ACT_kpLastPasswordResetDatetime); // if parsable with required format then valid
log.info date
DateFormat edf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")//20201015111554.595Z
Date edate = new Date()
log.info edate
assert edate.compareTo(date) <= 0, "Diff"