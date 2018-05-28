/*
 * eGov suite of products aim to improve the internal efficiency,transparency,
 *    accountability and the service delivery of the government  organizations.
 *
 *     Copyright (C) <2015>  eGovernments Foundation
 *
 *     The updated version of eGov suite of products as by eGovernments Foundation
 *     is available at http://www.egovernments.org
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see http://www.gnu.org/licenses/ or
 *     http://www.gnu.org/licenses/gpl.html .
 *
 *     In addition to the terms of the GPL license to be adhered to in using this
 *     program, the following additional terms are to be complied with:
 *
 *         1) All versions of this program, verbatim or modified must carry this
 *            Legal Notice.
 *
 *         2) Any misrepresentation of the origin of the material is prohibited. It
 *            is required that all modified versions of this material be marked in
 *            reasonable ways as different from the original version.
 *
 *         3) This license does not grant any rights to any user of the program
 *            with regards to rights under trademark law for use of the trade names
 *            or trademarks of eGovernments Foundation.
 *
 *   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */
var sorMsArray=new Array(200);
var nonSorMsArray=new Array(200);
var nonTenderedMsArray=new Array(200);
var lumpSumMsArray=new Array(200);
var headstart="<!--only for validity head start -->";
var headend="<!--only for validity head end -->";
var tailstart="<!--only for validity tail start -->";
var tailend="<!--only for validity tail end -->";


//Main add button click
$(document).on("click",".sub_measurement_add",function(event){
	event.stopImmediatePropagation();	
	var tdContent=$(this).closest('td').prev('td');
   	var idValue = $(tdContent).find('textarea').attr('id');
   	var array = idValue.split('.'); 
   	var resultId=array[0].replace('sorMbDetails','smd')+'.'+array[1].replace('measurementSheets','mdList'); 
   	var modelBody=$(this).next(".sub_measurement_add_modal").find('.modal-body');
   	modelBody.find('.submeasurement_prefix').val(resultId);
   	var clsCount=modelBody.find('.sub_row_content').length;
	   if(clsCount==1){
		   var firstElement=modelBody.find('.sub_row_content').first();
		   $(firstElement).find('.input_fields').each(function(){
			   var fname=$(this).data('fieldname');
			   var fid=resultId+'.submeasurements[0].'+fname;
			   $(this).attr('name',fid);
			   $(this).attr('id',fid);
		   })
		   /*   update id to all add buttons  */
           		      $(firstElement).find('div.shadow-text').each(function(){
                                  var existingId = this.id;
                                  var fname = existingId.substring(existingId.lastIndexOf('.')+1);
                                  var fid = 'div_' + resultId + '.submeasurements[0].' + fname;
                                  $(this).attr('id',fid);
                      	   });
	   }
	$(this).next(".sub_measurement_add_modal").modal("show");
});
$(document).on("keyup",".input_fields,.shadow-text",function(event){
console.log("in Key up");
debugger;

    if(event.which != 9 && event.keyCode != 9){
        $(this).parent().parent().find(".flagHidden").find('input:hidden').val('1');
        console.log('in log');
    }

});
//show diff btn


$(document).on("click",".subClose",function(event){
    $(this).parents(".sub_measurement_history_modal:eq(0)").modal("hide");
});

$(document).on("click",".show_diff",function(event){
    event.stopImmediatePropagation();
	var that = $(this);
    //Start
    var savedmbid = $('#selectedId').val();
    var modelBody = $(this).next(".sub_measurement_history_modal").find('.modal-body');
    var mb_ext_id=$(this).parent().find(">input:hidden").eq(0).val();


    if (savedmbid != undefined && savedmbid != null && savedmbid > 0) {
        $.ajax({
            url: '/egworks/mb/viewsub/showHistory/' + savedmbid+'/'+mb_ext_id,
            type: 'GET',
            //dataType: "json",
            //data:{id: id},
            success: function (data) {
                console.log("View data===>" + data);
                if (data != null && data != '')
                    var jsonobj = data;//$.parseJSON(data);
                var i = 0;
                $('.sub_child_row_content',modelBody).each(function(j){
                       if(j>0)
                        $(this).remove();
                });

                $.each(jsonobj, function (key, val) {

                    if (i > 0)
                        var d = $(modelBody).find('.sub_child_row_content').first().clone().appendTo($(modelBody).find('.sub_row').first());


                    var eleCount = modelBody.find('.sub_child_row_content').length - 1;
                    var lastElement = modelBody.find('.sub_child_row_content').last();

                    var resultId = modelBody.find('.submeasurement_child_prefix').val();
                    //====
                    $(d).find('.span_fields').each(function () {
                        var fname = $(this).data('fieldname');
                        console.log('143 line = ' + fname);
                        var fid = resultId + '.submeasurements[' + eleCount + '].' + fname;
                        $(this).attr('name', fid);
                        $(this).attr('id', fid);
                        //$(this).attr('value', '');
                        $(this).html('');
                    });
                    //====
                    $(lastElement).find('.span_fields').each(function () {
                        var fname = $(this).data('fieldname');
                        console.log('157 line = ' + fname);
                        var fid = resultId + '.submeasurements[' + eleCount + '].' + fname;
                        $(this).attr('name', fid);
                        $(this).attr('id', fid);

                        var htmlContent ="";
                         if(val[fname] != undefined && val[fname]!=null && val[fname]!=""){
                            var temp = val[fname] + "";
                            htmlContent = temp.replace('*p',"&#928");

                        }
                        $(this).html(htmlContent);
                    });
                    // update the IDs for divs maintained for lengthText, widthText, depthText


                    i++;
                });
                that.next(".sub_measurement_history_modal").modal("show");
                populateAllShadowTexts($('.sub_measurement_history_modal'));
            },
            error: function (data) {
                //alert(JSON.stringify(data));
            }
        });



      //that.next(".sub_measurement_history_modal").data("edit",false);
       }

























    //End  ---- Begin PENCHAL
});
$(document).on("click",".delete_submeasurement",function(event){
event.stopImmediatePropagation();

    var modelBody=$(this).parents('.modal-body:eq(0)');
    	var eleCount=$(modelBody).find('.sub_row_content').length;
    	if(eleCount>1){

    		$(this).parents('.sub_row_content:eq(0)').remove();//$(this).parent().parent().parent().remove();


            var lastElement=modelBody.find('.sub_row_content').last();
          //  $(lastElement).remove();



           // $(this).closest('.row').remove();



    	}
    	else
    	{
    		alert("Can't delete default row");
    	}
});

//PENCHAL
$(document).on("click",".sub_measurement_edit",function(event){
	event.stopImmediatePropagation();
	var tdContent=$(this).closest('td').prev('td');
   	var idValue = $(tdContent).find('textarea').attr('id');
   	var array = idValue.split('.');
   	var mbid = array[0]+'.'+array[1]+'.id';
   	var isedit = $(this).next(".sub_measurement_add_modal").data("edit");
   	var that = $(this);
   	//alert("Mbid: "+mbid+" - "+document.getElementsByName(mbid)[0].value);
   	var savedmbid = document.getElementsByName(mbid)[0].value;

   	var resultId=array[0].replace('sorMbDetails','smd')+'.'+array[1].replace('measurementSheets','mdList');
   	var modelBody=$(this).next(".sub_measurement_add_modal").find('.modal-body').eq(0);

   	modelBody.find('.submeasurement_prefix').val(resultId);
   	modelBody.find('.submeasurement_child_prefix').val(resultId);
   	var clsCount=modelBody.find('.sub_row_content').length;
   	var isexist=false;
   	console.log('clsCount=' + clsCount);
   if(clsCount==1){
	   var firstElement=modelBody.find('.sub_row_content').first();
	   $(firstElement).find('.input_fields').each(function(){
		   if($(this).val()!='' && $(this).val()!=null)
		   {
			   	isexist=true;
		   }
		   var fname=$(this).data('fieldname');
		   var fid=resultId+'.submeasurements[0].'+fname;
		   $(this).attr('name',fid);
		   $(this).attr('id',fid);
		   $(this).attr('value',$(this).val());
	   });
	   $(firstElement).find('div.shadow-text').each(function(){
            var existingId = this.id;
            var fname = existingId.substring(existingId.lastIndexOf('.')+1);
            var fid = 'div_' + resultId + '.submeasurements[0].' + fname;
            $(this).attr('id',fid);
	   });
   }
   else{
	   var firstElement=modelBody.find('.sub_row_content').first();
	   $(firstElement).find('.input_fields').each(function(){
		   if($(this).val()!='' && $(this).val()!=null)
		   {
			   	isexist=true;
			   	$(this).attr('value',$(this).val());
		   }
		   else{
			   $(this).attr('value',$(this).attr('value'));
		   }


	   })
   }
   $('#selectedId').val(savedmbid);
   if(isexist==false && savedmbid > 0){

	   $.ajax({
			url:'/egworks/mb/viewsub/'+savedmbid,
			type:'GET',
			//dataType: "json",
			//data:{id: id},
			success:function(data){
				console.log("View data===>"+data);
				if(data != null && data != '')
				 var jsonobj = $.parseJSON(data);
				 var i=0;
				 $.each(jsonobj, function(key, val) {

					if(i > 0)
					var d=$(modelBody).find('.sub_row_content').first().clone().appendTo($(modelBody).find('.sub_row').first());


					var eleCount=modelBody.find('.sub_row_content').length-1;
					var lastElement=modelBody.find('.sub_row_content').last();

					 var resultId=modelBody.find('.submeasurement_prefix').val();
					 //====
					 $(d).find('.input_fields').each(function(){
						 var fname=$(this).data('fieldname');
  					     console.log('143 line = ' + fname);
						 var fid=resultId+'.submeasurements['+eleCount+'].'+fname;
						 $(this).attr('name',fid);
						 $(this).attr('id',fid);
						 $(this).attr('value','');
						 $(this).val('');
						 if($(this).is("textarea"))
						 {
							 $(this).text('');

						 }
					 });
					 //====



					 $(lastElement).find('.input_fields').each(function(){
						   var fname=$(this).data('fieldname');
						   console.log('157 line = ' + fname);
						   var fid=resultId+'.submeasurements['+eleCount+'].'+fname;
						   $(this).attr('name',fid);
						   $(this).attr('id',fid);
						   $(this).attr('value',val[fname.toLowerCase()]);
						   $(this).val(val[fname.toLowerCase()]);
						   if($(this).is("textarea"))
							{
							   $(this).text(val[fname.toLowerCase()]);

							}
					   });
                        // update the IDs for divs maintained for lengthText, widthText, depthText
                        $(lastElement).find('div.shadow-text').each(function() {
                            var existingId = this.id;
                            console.log('173 existingId = ' + existingId);
                            var fname = existingId.substring(existingId.lastIndexOf('.')+1);
                            var fid = 'div_' + resultId + '.submeasurements[' + eleCount + '].' + fname;
                            console.log('176 fid = ' + fid);
                            $(this).attr('id',fid);
                        });

					 i++;
		        });
		         $(modelBody).find('.flagHidden input:hidden').each(function(){
                    var val = $(this).val();
                    if(val != null && val != undefined && parseInt(val) == 1)
                       $(this).parents('.sub_row_content:eq(0)').css('background-color','#90EE90').css('color','white')
                     else
                       $(this).parents('.sub_row_content:eq(0)').find('.show_diff').remove();

                 });
				that.next(".sub_measurement_add_modal").modal("show");
				populateAllShadowTexts($('.sub_measurement_add_modal'));
			},
			error: function(data){
				//alert(JSON.stringify(data));
				}
			});
	   that.next(".sub_measurement_add_modal").data("edit",false);
   }
   else
	   {
	   that.next(".sub_measurement_add_modal").modal("show");
	   }

	//that.next(".sub_measurement_add_modal").modal("show");
});


// populating all Divs (shadow texts)
function populateAllShadowTexts(obj) {
    $(obj).find('div.shadow-text').each(function() {
        //console.log(this.id);
        $(this).trigger('onfocus');
    });
}



////Add button click in popup window
$(document).on("click",".add_submeasurement",function(event){

	event.stopImmediatePropagation();


	var modelBody=$(this).closest('.modal-body');
	var d=$(modelBody).find('.sub_row_content').first().clone().appendTo($(modelBody).find('.sub_row').first());
	var eleCount=modelBody.find('.sub_row_content').length-1;
	var lastElement=modelBody.find('.sub_row_content').last();

	var resultId=modelBody.find('.submeasurement_prefix').val();
	// populating the IDs for cloned row
	$(lastElement).find('.input_fields').each(function(){
        var fname=$(this).data('fieldname');
        var fid=resultId+'.submeasurements['+eleCount+'].'+fname;
        $(this).attr('name',fid);
        $(this).attr('id',fid);
        $(this).attr('value','');
        $(this).val('');
        if($(this).is("textarea")) {
            $(this).text('');
        }
    });
    // update the IDs for divs maintained for lengthText, widthText, depthText
	$(lastElement).find('div.shadow-text').each(function(){
	    var existingId = this.id;
	    var prefix = existingId.substring(0, existingId.lastIndexOf('['));
	    var fname = existingId.substring(existingId.lastIndexOf('.')+1);
	    var fid = prefix + '[' + eleCount + '].' + fname;
        $(this).attr('id',fid);
        $(this).text('');
        $(this).html('');
    });

});

//Delete button click in popup window penchal
$(document).on("click",".delete_submeasurement",function(event){
	event.stopImmediatePropagation();
	var modelBody=$(this).closest('.modal-body');
	var eleCount=modelBody.find('.sub_row_content').length;
	if(eleCount>1){

     $(this).closest('.row').remove();

		var lastElement=modelBody.find('.sub_row_content').last();
		$(lastElement).remove();



	}
	else
	{
		alert("Can't delete default row");
	}
});

//Sum button click in popup window
$(document).on("click",".sum_submeasurement",function(event){

	event.stopImmediatePropagation();
	var SumNumber=0;
	var SumLength=0;
	var SumWidth=0;
	var SumHeight=0;
	var SumQty=0;
	var curRowNumber=1;
	var modelBody=$(this).parent().prev('.modal-body');
	$(modelBody).find('.input_fields').each(function(){
		 var fname=$(this).data('fieldname');
		 if(fname=="no"){
			 if(!isNaN($(this).val()) && $(this).val()!=null && $(this).val()!='')
				 curRowNumber=parseFloat($(this).val());
			 else curRowNumber=1;
		 }else if(fname=="length"){
			 if(!isNaN($(this).val()) && $(this).val()!="")
				 curRowLength=parseFloat($(this).val());
			 else curRowLength=1;
		 }else if(fname=="width"){
			 if(!isNaN($(this).val()) && $(this).val()!="")
				 curRowWidth=parseFloat($(this).val());
			 else{
				 curRowWidth=1;
			 }
		 }else if(fname=="depthOrHeight"){
			 if(!isNaN($(this).val()) && $(this).val()!="")
				 curRowHeight=parseFloat($(this).val());
			 else curRowHeight=1;
			SumQty=SumQty+(curRowNumber*curRowLength*curRowWidth*curRowHeight);
		 }
	   });

	var resultId=$(modelBody).find('.submeasurement_prefix').val();

  	resultId=resultId.replace('smd','sorMbDetails').replace('mdList','measurementSheets');
	var no= document.getElementById(resultId+'.no');
	no.setAttribute('value', '');

	//document.getElementById(resultId+'.length').value=SumLength;

	var len=document.getElementById(resultId+'.length');
	len.setAttribute('value', '');

	var wid=document.getElementById(resultId+'.width');
	wid.setAttribute('value', '');

	//document.getElementById(resultId+'.width').value=SumWidth;

	var ht=document.getElementById(resultId+'.depthOrHeight');
	ht.setAttribute('value', '');
	//document.getElementById(resultId+'.depthOrHeight').value=SumHeight;

	var qty=document.getElementById(resultId+'.quantity');
	qty.setAttribute('value', /*SumNumber*SumLength*SumWidth*SumHeight*/parseFloat(SumQty).toFixed(2));
	//alert("SumQty==>"+SumQty);
	//document.getElementById(resultId+'.quantity').value=SumNumber*SumLength*SumWidth*SumHeight;

	var finalId="#"+resultId+".no";
	findNet(document.getElementById(resultId+'.quantity'));
//	$('#'+resultId+'\\.no').attr('value', SumNumber);
//	$('#'+resultId+'\\.length').attr('value', SumLength);
//	$('#'+resultId+'\\.width').attr('value', SumWidth);
//	$('#'+resultId+'\\.depthOrHeight').attr('value', SumHeight);
	//$('.runtime-update').change();
	$(".sub_measurement_add_modal").modal("hide");
});

function addNewMBMSheet(t, val){
	var stringHtml = $("#msrowtemplate").html();
	//alert(stringHtml);
	var id = 2;
	id = parseInt(id) + $(".tbodysheet_"+t).find("tr.mstempq"+val).length;
	var index=parseInt(id)-1;
	//stringHtml = stringHtml.toString().replace("measurementSheets[0]","measurementSheets["+index+"]");
	/*
	 * */
	var htmlString='<td rowspan="1" class="rowclass" hidden="true"><input name="sorMbDetails[0].measurementSheets['+index+'].id" class="clearthis" id="sorMbDetails_0_measurementSheets_0_id"><input name="sorMbDetails[0].measurementSheets['+index+'].woMeasurementSheet" id="sorMbDetails_0_measurementSheets_0_woMeasurementSheet"></td>\
	                	<td id="msrowslNo_0_0" rowspan="1" class="rowclass"></td><td id="msrowremarks_0_0" rowspan="1" class="rowclass"></td>\
	                    <td id="msrowno_0_0" rowspan="1" class="rowclass" align="right"></td>\
	                    <td id="msrowlength_0_0" rowspan="1" class="rowclass" align="right"></td>\
	                    <td id="msrowwidth_0_0" rowspan="1" class="rowclass" align="right"></td>\
	                    <td id="msrowdepthOrHeight_0_0" rowspan="1" class="rowclass" align="right"></td>\
	                    <td id="msrowquantity_0_0" rowspan="1" class="rowclass" align="right"></td>\
	                    <td id="msrowidentifier_0_0" rowspan="1" class="rowclass"></td>\
	                    <td id="msrowmbmsPreviousEntry_0_0" rowspan="1" class="rowclass" align="right"></td>\
	                    <td><textarea name="sorMbDetails[0].measurementSheets['+index+'].remarks" value="" id="sorMbDetails[0].measurementSheets['+index+'].remarks" class="form-control text-left patternvalidation runtime-update" data-pattern="alphanumeric" maxlength="1024"></textarea></td>\
	                   	<td><input name="sorMbDetails[0].measurementSheets['+index+'].no" value="" onkeyup="limitCharatersBy3_2(this);" id="sorMbDetails[0].measurementSheets['+index+'].no" class="form-control text-right patternvalidation runtime-update" data-pattern="decimalvalue" data-idx="'+index+'"></td>\
	                   	<td><input name="sorMbDetails[0].measurementSheets['+index+'].length" onkeyup="limitCharatersBy10_4(this);" id="sorMbDetails[0].measurementSheets['+index+'].length" class="form-control text-right patternvalidation runtime-update" data-pattern="decimalvalue" data-idx="'+index+'"></td>\
	                    <td><input name="sorMbDetails[0].measurementSheets['+index+'].width" onkeyup="limitCharatersBy10_4(this);" id="sorMbDetails[0].measurementSheets['+index+'].width" class="form-control text-right patternvalidation runtime-update" data-pattern="decimalvalue" data-idx="'+index+'"></td>\
	                    <td><input name="sorMbDetails[0].measurementSheets['+index+'].depthOrHeight" onkeyup="limitCharatersBy10_4(this);" id="sorMbDetails[0].measurementSheets['+index+'].depthOrHeight" class="form-control text-right patternvalidation runtime-update" data-pattern="decimalvalue" data-idx="'+index+'"></td>\
	                    <td><input name="sorMbDetails[0].measurementSheets['+index+'].quantity" onkeyup="limitCharatersBy10_4(this);" id="sorMbDetails[0].measurementSheets['+index+'].quantity" class="form-control text-right patternvalidation runtime-update" data-pattern="decimalvalue" onblur="findNet(this)"></td>\
	                    <td class="addDeleteClass"></td>';//<button type="button" onclick="addNewMBMSheet('0')">Add</button>
	//stringHtml = stringHtml.toString().replace('data-idx="0"','data-idx="'+index+'");
	//alert(htmlString);
	//val=index-1;
	$(".tbodysheet_"+t).find(".msrowTemplateClass"+val).find("td.rowclass").attr("rowspan", id);
	$(".tbodysheet_"+t).find(".msrowTemplateClass"+val).after("<tr class='mstempq"+val+" msrowTemplateClass"+val+"-"+id+"'>"+htmlString+"</tr>");
	$(".tbodysheet_"+t).find(".msrowTemplateClass"+val+"-"+id).find("td.rowclass").remove();
	$(".tbodysheet_"+t).find(".msrowTemplateClass"+val+"-"+id).find(".addDeleteClass").html('<button type="button" onclick="delMBMSheet(\''+t+'\', \''+val+'\', \''+id+'\')">DEL</button>');
}

function delMBMSheet(parent, row, idv){
	$(".tbodysheet_"+parent).find(".msrowTemplateClass"+row+"-"+idv).remove();
	var id = $(".tbodysheet_"+parent).find("tr.mstempq"+row).length;
	id += 1;
	$(".tbodysheet_"+parent).find(".msrowTemplateClass"+row).find("td.rowclass").attr("rowspan", id);
}

function addMBMSheet(obj)
{
	var rowid=obj.id;
	sorId=rowid.split(".");
	var	sortable=sorId[0];
	var msfieldsName=rowid.replace("msadd","measurementSheets");
	var   mscontent=document.getElementById(rowid.replace("msadd","mstd")).innerHTML;
	var   msopen=document.getElementById(rowid.replace("msadd","msopen")).value;
	if(msopen==1)
		return ;

	if(mscontent!='')
	{


		if(mscontent.indexOf(headstart) >=0)
		  {
		  var head= mscontent.substring(mscontent.indexOf(headstart),mscontent.indexOf(headend));
		  var tail= mscontent.substring(mscontent.indexOf(tailstart),mscontent.indexOf(tailend));
		  mscontent= mscontent.replace(head,"");
		  mscontent= mscontent.replace(tail,"");
		  }

		var t = sortable.split("[")[1];
		t = t.split("]")[0];
		mscontent = mscontent.replace("tbodysheet", "tbodysheet_"+t);

		mscontent = mscontent.replace(/addNewMBMSheet\(/g, "addNewMBMSheet('"+t+"',")

		var curRow = $(obj).closest('tr');
		var k= "<tr id=\""+sortable+".mstr\" class=\"msheet-tr\"><td colspan=\"15\">";
		mscontent=k+mscontent+"</td></tr>";
		curRow.after(mscontent);
		document.getElementById(rowid.replace("msadd","mstd")).innerHTML="";
		document.getElementById(rowid.replace("msadd","msopen")).value="1";
		var idx=sortable.substr(sortable.indexOf("["),sortable.indexOf("]"));

		if(sortable.indexOf("sorMbDetails") >= 0)
		{
			sorMsArray[idx]=mscontent;
		} else if(sortable.indexOf("nonTenderedMbDetails") >= 0)
		{
			nonTenderedMsArray[idx]=mscontent;
		}
		else if(sortable.indexOf("lumpSumMbDetails") >= 0)
		{
			lumpSumMsArray[idx]=mscontent;
		}
		else
		{
			nonSorMsArray[idx]=mscontent;
		}

	}else
	{

		var curRow = $(obj).closest('tr');
		var newrow= $('#msheaderrowtemplate').html();
		newrow=  newrow.replace(/msrowtemplate/g,'msrow'+sortable);
		newrow=  newrow.replace(/templatesorMbDetails\[0\]/g,sortable);
		document.getElementById(rowid.replace("msadd","msopen")).value="1";
		document.getElementById(rowid.replace("msadd","mspresent")).value="1";
		curRow.after(newrow);
		var idx=sortable.substr(sortable.indexOf("["),sortable.indexOf("]"));
		if(sortable.indexOf("sorMbDetails") >= 0)
		{
			sorMsArray[idx]="";
		} else if(sortable.indexOf("nonTenderedMbDetails") >= 0)
		{
			nonTenderedMsArray[idx]="";
		}
		else if(sortable.indexOf("lumpSumMbDetails") >= 0)
		{
			lumpSumMsArray[idx]="";
		}
		else
		{
			nonSorMsArray[idx]="";
		}

	}
	patternvalidation();
	var s= $(mscontent).find('.row_qty');
	var v=0;
	$('.row_qty').each(function(){
		v=parseFloat($(this).html()).toFixed(2);
		$(this).html(v);
	});
}

$(document).on('click','.hide-ms',function () {

	var sid=$(this).closest('tr').attr("id");
	var name=	sid.split(".")[0]
	var idx=name.substr(name.indexOf("["),name.indexOf("]"));
	if(sid.split(".")[0].indexOf("sorMbDetails") >= 0)
	{
		document.getElementById(sid.split(".")[0]+".mstd").innerHTML=sorMsArray[idx];
		if(sorMsArray[idx].length==0)
			document.getElementById(sid.split(".")[0]+".mspresent").value="0";

	}else if(sid.split(".")[0].indexOf("nonTenderedMbDetails") >= 0)
	{
		document.getElementById(sid.split(".")[0]+".mstd").innerHTML=nonTenderedMsArray[idx];
		if(nonTenderedMsArray[idx].length==0)
			document.getElementById(sid.split(".")[0]+".mspresent").value="0";
	} else if(sid.split(".")[0].indexOf("lumpSumMbDetails") >= 0)
	{
		document.getElementById(sid.split(".")[0]+".mstd").innerHTML=lumpSumMsArray[idx];
		if(lumpSumMsArray[idx].length==0)
			document.getElementById(sid.split(".")[0]+".mspresent").value="0";

	}else
	{
		document.getElementById(sid.split(".")[0]+".mstd").innerHTML=nonSorMsArray[idx];
		if(nonSorMsArray[idx].length==0)
			document.getElementById(sid.split(".")[0]+".mspresent").value="0";
	}

	document.getElementById(sid.split(".")[0]+".msopen").value="0";

	var mstr=document.getElementById(sid.split(".")[0]+".mstr");
	$(mstr).remove();
});

$(document).on('change','.runtime-update',function (e) {
	if($(this).is("input"))
	{
		//console.log('input value change triggered!');
		if($(this).val()==0)
			{
			alert("Zero is not allowed");
			$(this).val('');
			}
		$(this).attr('value', $(this).val());
	}
	else if($(this).is("textarea"))
	{
		$(this).html($(this).val());
	}
	if($(this).attr('id').indexOf("quantity")>=0)
		findNet(this);
	else
		findTotal(this);
});

$(document).on('click','.ms-submit',function (event) {
	event.stopImmediatePropagation();
	var sid=$(this).attr("id");
	var mscontent="<tr id=\""+sid.split(".")[0]+".mstr\">";

	var net=eval(document.getElementById(sid.split(".")[0]+".msnet").innerHTML);
	if(net==NaN ||net==0)
	{
		//following 2 lines commented by OSL to allow negative quantity.
		//alert("Net quantity should be greater than 0");
		alert("Net quantity should not be 0");
		return false;
	}
	var qobj1=sid.split(".")[0];
	if(!validateMsheet(qobj1))
	{
		return false;
	}

	document.getElementsByName(sid.split(".")[0]+".quantity")[0].value=(parseFloat(document.getElementById(sid.split(".")[0]+".msnet").innerHTML).toFixed(2));
	mscontent=document.getElementById(sid.split(".")[0]+".mstr").innerHTML;
	document.getElementById(sid.split(".")[0]+".mstr")
	document.getElementById(sid.split(".")[0]+".mstd")
	document.getElementById(sid.split(".")[0]+".mstd").innerHTML=mscontent;
	document.getElementById(sid.split(".")[0]+".msopen").value="0";
	var mstr=document.getElementById(sid.split(".")[0]+".mstr");
	$(mstr).remove();
	var qobj=document.getElementsByName(sid.split(".")[0]+".quantity")[0];
	if(sid.split(".")[0].indexOf("sorMbDetails") >= 0)
	{
		calculateSorAmounts(document.getElementsByName(sid.split(".")[0]+".quantity")[0]);
	}else if(sid.split(".")[0].indexOf("nonTenderedMbDetails") >= 0)
	{
		calculateNonTenderedAmounts(document.getElementsByName(sid.split(".")[0]+".quantity")[0]);
	} else if(sid.split(".")[0].indexOf("lumpSumMbDetails") >= 0)
	{
		calculateLumpSumAmounts(document.getElementsByName(sid.split(".")[0]+".quantity")[0]);
	}else
	{
		calculateNonSorAmounts(document.getElementsByName(sid.split(".")[0]+".quantity")[0]);
	}
});

function reindex(tableId)
{

	var idx=0;
	tbl=document.getElementById(tableId);
	////console.log($(tbl).html());

	$(tbl).find("tbody tr").each(function(e) {

		//console.log('for loop');
		$(this).find("input,select,textarea").each(function() {
			var classval = jQuery(this).attr('class');
			if(classval.indexOf("spanslno") > -1) {
				jQuery(this).val(idx+1);
			}

			$(this).attr({
				'name' : function(_, name) {
					if(name)
						return name.replace(/measurementSheets\[.\]/g, "measurementSheets["+idx+"]");
				},
				'id' : function(_, id) {
					if(id)
						return id.replace(/measurementSheets\[.\]/g, "measurementSheets["+idx+"]");
				},
				'data-idx' : function(_, dataIdx) {
					return idx;
				}
			});

		});
		idx++;
	});


}

$(document).on('click','.reset-ms',function () {
	var len=$(this).closest('table').find('.runtime-update').val("");
});

$(document).on('focus',".datepicker", function(){
	$(this).datepicker({format: "dd/mm/yyyy",
		 autoclose: true});
});

function findTotal(obj)
{
	var name=obj.name.split(".");
	var lengthname=name[0]+'.'+name[1]+'.length';
	var no1,depthOrHeight1,width1,length1;
	var lent=$('input[id="'+lengthname+'"]');
	//console.log($(lent).attr('value'));
	var length=$(lent).attr('value');
	var no=$('input[id="'+name[0]+'.'+name[1]+'.no'+'"]').attr('value');
	var depthOrHeight=$('input[id="'+name[0]+'.'+name[1]+'.depthOrHeight'+'"]').attr('value');
	var width=$('input[id="'+name[0]+'.'+name[1]+'.width'+'"]').attr('value');

	if(isEmpty(length) && isEmpty(no) && isEmpty(depthOrHeight)  && isEmpty(width))
		$('input[id="'+name[0]+'.'+name[1]+'.quantity'+'"]').attr('value',0);
	else {
		if (length === undefined || length == '' || length == 0)
			length = 1;
		if (no === undefined || no == '' || no == 0)
			no = 1;
		if (depthOrHeight === undefined || depthOrHeight == '' || depthOrHeight == 0)
			depthOrHeight = 1;
		if (width === undefined || width == '' || width == 0)
			width = 1;
		var net=parseFloat(length * no * width * depthOrHeight).toFixed(2);

		document.getElementById(name[0]+'.'+name[1]+'.quantity').value=net;
		$('input[id="'+name[0]+'.'+name[1]+'.quantity'+'"]').attr('value',(net).toFixed(2));

	}
	var netObj=document.getElementById(name[0]+'.'+name[1]+'.quantity');
	//$(netObj).attr('value', (document.getElementById(name[0] + '.' + name[1] + '.quantity').value).toFixed(2));
	if(netObj !=null && netObj!=undefined){
		$(netObj).attr('value', (netObj.value).toFixed(2));
		var len=$(obj).closest('table').find('tbody').children.length;
		//console.log(len);
		if(name[0].indexOf("sorMbDetails") >= 0)
			findNet(netObj);
		else if(name[0].indexOf("nonTenderedMbDetails") >= 0)
			findNonTenderedNet(netObj);
		else if(name[0].indexOf("lumpSumMbDetails") >= 0)
			findLumpSumNet(netObj);
		else
			findNonSorNet(netObj);
	}
}

function isEmpty(str)
{
	if(!str)
	{
		return true;
	}
	else if(!str.trim()) {
		return true;
	}

	return false;
}


function findNet(obj)
{
	var len=$(obj).closest('tbody').find('tr').length;
	var name=obj.id.split(".");
	var index = name[0].split('[')[1].split(']')[0];

	var sum=0;
	for(var i=0;i<len - 1;i++)
	{
		var qname=name[0]+'.measurementSheets['+i+'].quantity';
		var quantity=eval(document.getElementById(qname).value);
		var oname= '#msrowidentifier_' + index + '_' + i;
		var operation=$(oname).html().trim();
		console.log(quantity+"---"+operation);
		if(quantity===undefined)
			quantity=0;
		if(quantity==NaN)
			quantity=0;
		if(quantity=='')
			quantity=0;
		if(operation=='No')
			sum=sum+quantity;
		else
			sum=sum-quantity;
	}
	//var fname=obj.name.split(".");
	var netName=name[0]+'.msnet';
	sum=parseFloat(sum).toFixed(2);

	//console.log(document.getElementById(netName).innerHTML);
	document.getElementById(netName).innerHTML=sum;
}

function findNonTenderedNet(obj)
{
	var len=$(obj).closest('tbody').find('tr').length;

	var name=obj.id.split(".");

	var index = name[0].split('[')[1].split(']')[0];

	var sum=0;
	for(var i=0;i<len - 1;i++)
	{
		var qname=name[0]+'.measurementSheets['+i+'].quantity';
		var quantity=eval(document.getElementById(qname).value);
		var oname= '#nontenderedmsrowidentifier_' + index + '_' + i;
		var operation=$(oname).html().trim();
		console.log(quantity+"---"+operation);
		if(quantity===undefined)
			quantity=0;
		if(quantity==NaN)
			quantity=0;
		if(quantity=='')
			quantity=0;
		if(operation=='No')
			sum=sum+quantity;
		else
			sum=sum-quantity;
	}
	//var fname=obj.name.split(".");
	var netName=name[0]+'.msnet';
	sum=parseFloat(sum).toFixed(2);
	//console.log(document.getElementById(netName).innerHTML);
	document.getElementById(netName).innerHTML=sum;
}


function findLumpSumNet(obj)
{
	var len=$(obj).closest('tbody').find('tr').length;

	var name=obj.id.split(".");

	var index = name[0].split('[')[1].split(']')[0];

	var sum=0;
	for(var i=0;i<len - 1;i++)
	{
		var qname=name[0]+'.measurementSheets['+i+'].quantity';
		var quantity=eval(document.getElementById(qname).value);
		var oname= '#lumpsummsrowidentifier_' + index + '_' + i;
		var operation=$(oname).html().trim();
		console.log(quantity+"---"+operation);
		if(quantity===undefined)
			quantity=0;
		if(quantity==NaN)
			quantity=0;
		if(quantity=='')
			quantity=0;
		if(operation=='No')
			sum=sum+quantity;
		else
			sum=sum-quantity;
	}
	//var fname=obj.name.split(".");
	var netName=name[0]+'.msnet';
	sum=parseFloat(sum).toFixed(2);
	//console.log(document.getElementById(netName).innerHTML);
	document.getElementById(netName).innerHTML=sum;
}

function findNonSorNet(obj)
{
	var len=$(obj).closest('tbody').find('tr').length;

	var name=obj.id.split(".");

	var index = name[0].split('[')[1].split(']')[0];

	var sum=0;
	for(var i=0;i<len - 1;i++)
	{
		var qname=name[0]+'.measurementSheets['+i+'].quantity';
		var quantity=eval(document.getElementById(qname).value);
		var oname= '#nonsormsrowidentifier_' + index + '_' + i;
		var operation=$(oname).html().trim();
		console.log(quantity+"---"+operation);
		if(quantity===undefined)
			quantity=0;
		if(quantity==NaN)
			quantity=0;
		if(quantity=='')
			quantity=0;
		if(operation=='No')
			sum=sum+quantity;
		else
			sum=sum-quantity;
	}
	//var fname=obj.name.split(".");
	var netName=name[0]+'.msnet';
	sum=parseFloat(sum).toFixed(2);
	//console.log(document.getElementById(netName).innerHTML);
	document.getElementById(netName).innerHTML=sum;
}

function openAllmsheet() {
	$(".openmbsheet:visible").each(function() {
		$(this).trigger('click');
	});
}

function closeAllmsheet() {
	$(".hide-ms:visible").each(function() {
		$(this).trigger('click');
	});
}

function ismsheetOpen()
{
	var open=false;
	$('.classmsopen').each(function (index)
			{

		if($( this ).val()==1)
			open=true
			});
	return open;
}

function validateMsheet(obj)
{
	var len=$(obj).closest('tbody').find('tr').length;
	var sum=0;
	for(var i=0;i<len-1;i++){
		var remarks=document.getElementById(obj+'.measurementSheets['+i+'].remarks').value;
		var no=eval(document.getElementById(obj+'.measurementSheets['+i+'].no').value);
		var lent=eval(document.getElementById(obj+'.measurementSheets['+i+'].length').value);
		var width=eval(document.getElementById(obj+'.measurementSheets['+i+'].width').value);
		var depthorheight=eval(document.getElementById(obj+'.measurementSheets['+i+'].depthOrHeight').value);
		var quantity=eval(document.getElementById(obj+'.measurementSheets['+i+'].quantity').value);

		if ((remarks != '' || no != '' || lent != '' || width != '' || depthorheight != '') && quantity == '') {
			bootbox.alert("Please Enter Quantity");
			return false;
		}
	}
	return true;
}

function limitCharatersBy10_4(object) {
	var valid = /^[0-9](\d{0,9})(\.\d{0,4})?$/.test($(object).val()),
	val = $(object).val();
	if(!valid){
		//console.log("Invalid input!");
		$(object).val(val.substring(0, val.length - 1));
	}
}
function limitCharatersBy10_2(object) {
	var valid = /^[0-9](\d{0,9})(\.\d{0,2})?$/.test($(object).val()),
	val = $(object).val();
	if(!valid){
		//console.log("Invalid input!");
		$(object).val(val.substring(0, val.length - 1));
	}
}
function limitCharatersBy3_2(object) {
	if($(object).val()=="-") return;
	var valid = /^-?[0-9](\d{0,2})(\.\d{0,2})?$/.test($(object).val());
	val = $(object).val();
	if(!valid){
		//console.log("Invalid input!");
		$(object).val(val.substring(0, val.length - 1));
	}
}

function viewMBHistory() {
	var mbheaderId = $('#id').val();
	window.open("/egworks/mb/history/" + mbheaderId, '', 'height=650,width=980,scrollbars=yes,left=0,top=0,status=yes');
}

//Deltamarc
function calculate(obj)
{
  var rowcontent=obj.closest('.sub_row_content');
  var no_val = 1.0;
  $(rowcontent).find('.input_fields').each(function(){
    var fname=$(this).data('fieldname');
    if (fname === 'numone' || fname === 'numtwo') {
      no_val = no_val * parseFloat($(this).val());
    }
  });
  $(rowcontent).find('.input_fields').each(function(){
    var fname=$(this).data('fieldname');
    if (fname === 'no') {
      $(this).val(no_val.toFixed(2));
      $(this).attr('value', no_val.toFixed(2));
    }
  });
}



function replacePI(obj) {
  if ($(obj).html() != '') {
    var rowContent = $(obj).closest('.sub_row_content');
    console.log('objId='+obj.id);
    var hiddenFieldId = new String(obj.id).substr(4);
    console.log('hiddenFieldId='+hiddenFieldId);
    var existingText = loadObj(hiddenFieldId, rowContent).val();
    $(obj).html(existingText);
    console.log('replacedHtml='+$(obj).html());
  }
}


function calculateVal(obj, valueField)
{
  var rowContent = $(obj).closest('.sub_row_content');

  console.log('objId='+obj.id);
  var hiddenFieldId = new String(obj.id).substr(4);
  console.log('hiddenFieldId='+hiddenFieldId);

  var existingText = $(obj).text();
  console.log('existingText='+existingText);

  var replacedHtml = existingText.replace(/p/g, '&#928');
  console.log('replacedHtml='+replacedHtml);
  $(obj).html( replacedHtml );
  console.log('loaded html='+ $(obj).html());

  loadObj(hiddenFieldId, rowContent).val( existingText );
  console.log('loaded text='+ loadObj(hiddenFieldId).val());

  // update value field
  var calculated_val = eval(existingText.replace(/p/g, '(3.14)'));
  console.log('calculated_val = '+ calculated_val);
  var valueFieldId = hiddenFieldId.substring(0, hiddenFieldId.lastIndexOf('.')) + '.' + valueField;
  console.log('valueFieldId = '+ valueFieldId);
  loadObj(valueFieldId, rowContent).val(calculated_val.toFixed(2));
  loadObj(valueFieldId, rowContent).attr('value', calculated_val.toFixed(2));

  // update quantity
  var quantityFieldId = hiddenFieldId.substring(0, hiddenFieldId.lastIndexOf('.')) + '.quantity';
  updateQty(loadObj(quantityFieldId, rowContent));

}


function loadObj( myid, closestParent ) {
    var escapedId = myid.replace( /(:|\.|\[|\]|,|=|@)/g, "\\$1" );
    if (closestParent != undefined) {
        return $(closestParent).find("#" + escapedId);
    } else {
        return $("#" + escapedId);
    }
}







function calculatewidth(obj)
{
  var rowcontent=obj.closest('.sub_row_content');

  var width_val = 1.0;
  $(rowcontent).find('.input_fields').each(function(){
    var fname=$(this).data('fieldname');
    if (fname === 'widthText') {
      width_val = eval($(this).val());
    }
  });
  $(rowcontent).find('.input_fields').each(function(){
    var fname=$(this).data('fieldname');
    if (fname === 'width') {
      $(this).val(width_val.toFixed(2));
      $(this).attr('value', width_val.toFixed(2));
    }
  });
}




function calculatedepth(obj)
{
  var rowcontent=obj.closest('.sub_row_content');

  var depth_val = 1.0;
  $(rowcontent).find('.input_fields').each(function(){
    var fname=$(this).data('fieldname');
    if (fname === 'depthText') {
      depth_val = eval($(this).val());
    }
  });
  $(rowcontent).find('.input_fields').each(function(){
    var fname=$(this).data('fieldname');
    if (fname === 'depthOrHeight') {
      $(this).val(depth_val.toFixed(2));
      $(this).attr('value', depth_val.toFixed(2));
    }
  });
}



function updateQty(obj){
    console.log('updateQty called-1 >> ' + obj);
	var rowcontent = obj.closest('.sub_row_content');
	console.log('rowcontent >> ' + rowcontent);
	var rNumber=1;
	var rowLength=1;
	var rowWidth=1;
	var rowHeight=1;
	$(rowcontent).find('.input_fields').each(function(){
		//alert($(this).val());
		var fname=$(this).data('fieldname');
		console.log('fname >> ' + fname);
		if(fname=="no"){
			 if(!isNaN($(this).val()) && $(this).val()!=null && $(this).val()!='')
				 rNumber=parseFloat($(this).val());
			 else rNumber=1;
			 console.log('rNumber >> ' + rNumber);
		 }else if(fname=="length"){
			 if(!isNaN($(this).val()) && $(this).val()!=null && $(this).val()!='')
				 rowLength=parseFloat($(this).val());
			 else rowLength=1;
			 console.log('rowLength >> ' + rowLength);
		 }else if(fname=="width"){
			 if(!isNaN($(this).val()) && $(this).val()!=null && $(this).val()!='')
				 rowWidth=parseFloat($(this).val());
			 else rowWidth=1;
			 console.log('rowWidth >> ' + rowWidth);
		 }else if(fname=="depthOrHeight"){
			 if(!isNaN($(this).val()) && $(this).val()!=null && $(this).val()!='')
				 rowHeight=parseFloat($(this).val());
			 else rowHeight=1;
			 console.log('rowHeight >> ' + rowHeight);
			//SumQty=SumQty+(curRowNumber*curRowLength*curRowWidth*curRowHeight);
		 }else if(fname=="quantity"){
			 //alert("rNumber*rowLength*rowWidth*rowHeight>>> "+rNumber*rowLength*rowWidth*rowHeight);
			 $(this).val((rNumber*rowLength*rowWidth*rowHeight).toFixed(2));
			 $(this).attr('value',(rNumber*rowLength*rowWidth*rowHeight).toFixed(2));
			 var qty= document.getElementById($(this).attr('id'));
			 qty.setAttribute('value', (rNumber*rowLength*rowWidth*rowHeight).toFixed(2));
		 }
	});
}

$('html').bind('keypress', function(e){
	// code to reject form submission on enter key press
		   if(e.keyCode == 13)
		   {
		      return false;
		   }
		});
