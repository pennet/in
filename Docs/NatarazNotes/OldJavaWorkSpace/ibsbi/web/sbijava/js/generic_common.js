$(document).ready(function(){
	
	
	
	
	//Anchor Tag
	$('A[rel="_blank"]').each(function(){
        $(this).attr('target', '_blank');
    });
	
	//Custom Select
	$(".custom-select").each(function(){
		$(this).wrap("<span class='select-wrapper'></span>");
		$(this).after("<span class='holder'></span>");
	});
	
	$(".custom-select").change(function(){
		var selectedOption = $(this).find(":selected").text();
		$(this).next(".holder").text(selectedOption);
	}).trigger('change');
	
	//Theme Swicther
	$('#theme2').click(function(){
			$('body').addClass("bodytheme2");
			$('#navigation, #primary_navigation').css("background-color","#111");
			$('.banking_section').css("background-color","#444");
			$('.banking_section p, .newuser li a').css("color","#47dbff");
        }); 
                                
	$('#theme1').click(function(){
		$('body').removeClass("bodytheme2").addClass("bodytheme1");
		$('#navigation, #primary_navigation').css("background-color","#0c376a");
		$('.banking_section').css("background-color","#F8F8F8");
		$('.banking_section p, .newuser li a').css("color","#333");
	});
	
	// Font Resize
	var currentFontSize;
	var currentFontSizeNum;
	var newFontSize;
	var fontCount = 1;
	var data_Font;
	$("#reset").click(function(){ // Reset Font Size
		$('body *').each(function(){
			$(this).css('font-size','');
			fontCount = 1;
		});
	});
	
	// Increase Font Size
	  $("a#fontSizePlus").click(function(){
		  if(fontCount <= 1){
			fontCount++;
			$('.banking_section p,.register,.how').each(function(){
				currentFontSize = $(this).css('font-size');
				currentFontSizeNum = parseInt(currentFontSize.replace('px',''));
				newFontSize = currentFontSizeNum+2;
				$(this).css('font-size', ''+newFontSize+'px');
			});
		  }
		return false;
	  });
	
	// Accordian - Netbanking branches
		
		$('#netbanking_branches a').click(function(){
			if($('#netbanking_popup').is(':hidden')) {
				$('#netbanking_popup').slideDown(400);
				$('#header').animate({'marginTop':'126px'});
				$(this).addClass('netbanking_button_up');
			}else{
				$('#netbanking_popup').slideUp(400);
				$('#header').animate({'marginTop':'0px'});
				$(this).removeClass('netbanking_button_up');
			}
		});
	
	
	/*Slider*/
    $.fn.slider = function(o) {
        // slider default settings
        var defaults        = { // transition valuess
            animduration    : 1000,      // length of transition
            animspeed       : 12000    // delay between transitions
        };

        // create settings from defauls and user options
        var settings        = $.extend({}, defaults, o);

        // slider elements
        var $wrapper        = this,
            $slider         = $wrapper.find('ul.slider-item'),
            $slides         = $slider.children('li'),
            $m_wrapper      = null, // marker elements
            $m_markers      = null;


        // state management object
        var state           = {
            animating       : false,            // bool: is transition is progress
            currentslide    : 1,                // current slide being viewed (not 0 based)
            nextslide       : 0,                // slide to view next (not 0 based)
            currentindex    : 0,                // current slide being viewed (0 based)
            nextindex       : 0,                // slide to view next (0 based)
            interval        : null              // interval for automatic rotation
        };

        // run through options and initialise settings
        var init = function(){
            $slides.addClass('slider-item-slide'); // differentiate slider li from content li
			conf_markers(); // create and show markers
			showDefaultComp();
            // kick off the interval
			state.interval = setInterval(function () {
				go(false);
			}, settings.animspeed);
        };

		var showDefaultComp = function(){
			setTimeout(function(){// slide components are hidden by default, show them now
				$slider.show();
				$slides.eq(state.currentindex).show();
			},10);
		}

        var conf_markers = function() {
            $m_wrapper = $('<ol class="slider-item-markers"></ol>');// create a wrapper for our markers
            // for every slide, create a marker
            $.each($slides, function(key, slide){
                var slidenum    = key + 1,
                    gotoslide   = key + 1;
                var marker = $('<li><a href="#" title="Banner">&nbsp;</a></li>');
                // set the first marker to be active
                if(slidenum === state.currentslide){ marker.addClass('active-marker'); }

                // bind the click event
                marker.on('click','a',function(e){
                    e.preventDefault();
                    if(!state.animating && state.currentslide !== gotoslide){
                        go(gotoslide);
                    }
                });
                marker.appendTo($m_wrapper); // add the marker to the wrapper
            });
            $m_wrapper.appendTo($wrapper);
            $m_markers = $m_wrapper.find('li');
        };


        var set_next = function() {
			if($slides.eq(state.currentindex).next().length){
				state.nextindex = state.currentindex + 1;
				state.nextslide = state.currentslide + 1;
			}else{
				state.nextindex = 0;
				state.nextslide = 1;
			}
        };

        var go = function(position) {
            if(!state.animating){
                state.animating = true;
                if(position){
                    state.nextslide = position;
                    state.nextindex = position-1;
                }else{
                    set_next();
                }
				$m_markers.removeClass('active-marker');
				$m_markers.eq(state.nextindex).addClass('active-marker');
				$slides.eq(state.currentindex).fadeOut(settings.animduration);
				$slides.eq(state.nextindex).fadeIn(settings.animduration, function(){
					state.animating = false;
					state.currentslide = state.nextslide;
					state.currentindex = state.nextindex;

				});
            }
        };
        init();

    };
	
	
	
});

//Corporate Dropdown
function goToNewPage(){
	var corporateValue = document.getElementById('target').value;
	if(corporateValue == "Select")
	{
		alert("Please Select Corporate Type");
	}
	else
	{
		if(document.getElementById('target').value){
			window.location.href = document.getElementById('target').value;
		}
	}
}

//New User Click
function fnNewUserClick(){
      var retVal = confirm("If you have already obtained Pre-Printed Kit  from the branch for activating INB facility , please don't proceed  with this link. You can input userid and password given in PPK on normal login screen.");
      if( retVal == true ){ 
            window.open('#about','aboutus','width=920, height=500 ,status=1, scrollbars=1, location=0');
      }
}

//Salary Account
function salaryClick(){
      var salVal = confirm("Salary Account  link is meant for opening salary account of such employee(s), whose employer have tie up with SBI under Corporate Salary Package. If your employer does not have such tie-up, please go to Regular Savings Account link.");
      if( salVal == true ){ 
            window.open('#onsbi');
      }
}

