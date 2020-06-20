var today = new Date();
Date.prototype.getWeekNumber = function(){
	  var d = new Date(Date.UTC(this.getFullYear(), this.getMonth(), this.getDate()));
	  var dayNum = d.getUTCDay() || 7;
	  d.setUTCDate(d.getUTCDate() + 4 - dayNum);
	  var yearStart = new Date(Date.UTC(d.getUTCFullYear(),0,1));
	  return Math.ceil((((d - yearStart) / 86400000) + 1)/7);
};

//var w=today.getFullYear()+'-W'+ new Date().getWeekNumber();
//document.getElementById("idInputWeek").value = w ;	
// lấy ra ngày đầu tuần
function getDateOfISOWeek(w, y) {
    var simple = new Date(y, 0, 1 + (w - 1) * 7);
    var dow = simple.getDay();
    var ISOweekStart = simple;
    if (dow <= 4)
        ISOweekStart.setDate(simple.getDate() - simple.getDay() + 1);
    else
        ISOweekStart.setDate(simple.getDate() + 8 - simple.getDay());
    return ISOweekStart;
}
function getWeekNumber(d) {
    d = new Date(Date.UTC(d.getFullYear(), d.getMonth(), d.getDate()));
    d.setUTCDate(d.getUTCDate() + 4 - (d.getUTCDay()||7));
    var yearStart = new Date(Date.UTC(d.getUTCFullYear(),0,1));
    var weekNo = Math.ceil(( ( (d - yearStart) / 86400000) + 1)/7);
    return [d.getUTCFullYear(), weekNo];
}
$(document).ready(function() { 
	$("#nextWeek").click(function() {
		var temp = document.getElementById("idInputWeek").value.split('-W');
		var year = temp[0];
		var week = temp[1];
		var date = getDateOfISOWeek(week,year);
		var nextDay = new Date(date);
		nextDay.setDate(date.getDate() + 7);
		var weekInYear = getWeekNumber(nextDay);
		if(weekInYear[1]<10){
			var w=weekInYear[0]+'-W0'+ weekInYear[1];
		} else{
			var w=weekInYear[0]+'-W'+ weekInYear[1];
		}
		document.getElementById("idInputWeek").value = w ;
		$('#idInputWeek').change();
    });
	$("#preWeek").click(function() {
		var temp = document.getElementById("idInputWeek").value.split('-W');
		var year = temp[0];
		var week = temp[1];
		var date = getDateOfISOWeek(week,year);
		var nextDay = new Date(date);
		nextDay.setDate(date.getDate() - 7);
		var weekInYear = getWeekNumber(nextDay);
		if(weekInYear[1]<10){
			var w=weekInYear[0]+'-W0'+ weekInYear[1];
		} else{
			var w=weekInYear[0]+'-W'+ weekInYear[1];
		}
		document.getElementById("idInputWeek").value = w ;
		$('#idInputWeek').change();
    });
	//scroll table
	$('#dtVerticalScrollExample').DataTable({
	"scrollY": "500px",
	"scrollCollapse": true,
	});
	$('.dataTables_length').addClass('bs-select');
	// get theo tuần
	 $('#idInputWeek').on('change', function (e) {
		 var weekInYear = document.getElementById("idInputWeek").value;
		 if(weekInYear){
			 window.location = "/admin/thong-tin-dang-ky-lich?action=thongtindangkylich&weekinyear="+weekInYear;
		 }
	    
	 });
	
});





