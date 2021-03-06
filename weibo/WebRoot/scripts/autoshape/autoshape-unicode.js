if (typeof window.AutoshapeJS !== 'undefined' && typeof AutoshapeJS.defineShape !== 'undefined') {
	// Unicode
	AutoshapeJS.defineShape(
		'Unicode',
		{
			init: function (config) {
				arguments.callee._super(this, config);
				
				this.setStyle('font-family', 'Arial Unicode MS');
			},
			attributes: {
				height: function (value) {
					this.setStyle('font-size', value);
					this.setStyle('line-height', value);
				},
				character: function (value) {
					// Is the character value a hex value?
					if (value.match(/#[\d]{2,}/)) {
						this.element.innerHTML = '&' + value + ';';
						return true;
					}
					
					// Dictionary lookup for the unicode value
					if (typeof this.characters[value] === 'undefined') { return false; }
					this.element.innerHTML = this.characters[value];
				}
			},
			config: {
				height: '50px',
				character: 'square'
			},
			characters: {
				// Squares
				'square':'&#9632;',
				'square_filled':'&#9632;',
				'square_unfilled':'&#9633;',
				'square_rounded':'&#9634;',
				'square_horiz_fill':'&#9636;',
				'square_vertical_fill':'&#9637;',
				'square_crosshatch_fill':'&#9638;',
				'square_ullr_fill':'&#9639;',
				'square_urll_fill':'&#9640;',
				'square_lhalf_filled':'&#9703;',
				'square_rhalf_filled':'&#9704;',
				'square_ul_filled':'&#9705;',
				'square_lr_filled':'&#9706;',
				
				// Rectangles
				'rect_horiz_filled':'&#9644;',
				'rect_horiz_unfilled':'&#9645;',
				'rect_vertical_filled':'&#9646;',
				'rect_vertical_unfilled':'&#9647;',
				'rect_shaded_light':'&#9617',
				'rect_shaded_medium':'&#9618',
				'rect_shaded_dark':'&#9619',
				
				// Parallelograms
				'parallel_filled':'&#9648;',
				'parallel_unfilled':'&#9649;',
				
				// Triangles
				'triangle_filled':'&#9650;',
				'triangle_unfilled':'&#9651;',
				'triangle_rangle_right':'&#9698;',
				'triangle_rangle_left':'&#9699;',
				
				// Diamonds
				'diamond_filled':'&#9670;',
				'diamond_unfilled':'&#9671;',
				
				// Circles
				'circle_filled':'&#9679;',
				'circle_unfilled':'&#9675;',
				'circle_dotted':'&#9676;',
				'circle_vertical_fill':'&#9677;',
				'circle_lhalf_filled':'&#9680;',
				'circle_rhalf_fllled':'&#9681;',
				'circle_bhalf_filled':'&#9682;',
				'circle_thalf_filled':'&#9683;',
				'circle_quad_filled':'&#9684;',
				'circle_quad_unfilled':'&#9685;',
				'circle_left':'&#9686;',
				'circle_right':'&#9687;',
				'arc_ul':'&#9692;',
				'arc_ur':'&#9693;',
				'arc_lr':'&#9694;',
				'arc_ll':'&#9695;',
				'bullseye':'&#9678',
				'fisheye':'&#9673;',
				
				// Greek
				'greek_capital_alpha':'&#913;',
				'greek_capital_beta':'&#914;',
				'greek_capital_gamma':'&#915;',
				'greek_capital_delta':'&#916;',
				'greek_capital_epsilon':'&#917;',
				'greek_capital_zeta':'&#918;',
				'greek_capital_eta':'&#919;',
				'greek_capital_theta':'&#920;',
				'greek_capital_iota':'&#921;',
				'greek_capital_kappa':'&#922;',
				'greek_capital_lamda':'&#923;',
				'greek_capital_mu':'&#924;',
				'greek_capital_nu':'&#925;',
				'greek_capital_xi':'&#926;',
				'greek_capital_omicron':'&#927;',
				'greek_capital_pi':'&#928;',
				'greek_capital_phi':'&#929;',
				'greek_capital_rho':'&#930;',
				'greek_capital_sigma':'&#931;',
				'greek_capital_tau':'&#932;',
				'greek_capital_upsilon':'&#933;',
				'greek_capital_phi':'&#934;',
				'greek_capital_chi':'&#935;',
				'greek_capital_psi':'&#936;',
				'greek_capital_omega':'&#937;',
				'greek_lower_alpha':'&#945;',
				'greek_lower_beta':'&#946;',
				'greek_lower_gamma':'&#947;',
				'greek_lower_delta':'&#948;',
				'greek_lower_epsilon':'&#949;',
				'greek_lower_zeta':'&#950;',
				'greek_lower_eta':'&#951;',
				'greek_lower_theta':'&#952;',
				'greek_lower_iota':'&#953;',
				'greek_lower_kappa':'&#954;',
				'greek_lower_lamda':'&#955;',
				'greek_lower_mu':'&#956;',
				'greek_lower_nu':'&#957;',
				'greek_lower_xi':'&#958;',
				'greek_lower_omicron':'&#959;',
				'greek_lower_pi':'&#960;',
				'greek_lower_phi':'&#961;',
				'greek_lower_rho':'&#962;',
				'greek_lower_sigma':'&#963;',
				'greek_lower_tau':'&#964;',
				'greek_lower_upsilon':'&#965;',
				'greek_lower_phi':'&#966;',
				'greek_lower_chi':'&#967;',
				'greek_lower_psi':'&#968;',
				'greek_lower_omega':'&#969;',
				
				// Misc
				'sun':'&#9728;',
				'cloud':'&#9729;',
				'umbrella':'&#9730;',
				'snowman':'&#9731;',
				'star_filled':'&#9733;',
				'star_unfilled':'&#9734;',
				'telephone':'&#9742;',
				'ballot_box':'&#9744;',
				'ballot_box_check':'&#9744;',
				'ballot_bot_x':'&#9744;',
				'point_left':'&#9754;',
				'point_right':'&#9755;',
				'skull_bones':'&#9760;',
				'radioactive':'&#9762;',
				'biohazard':'&#9763;',
				'caduceus':'&#9764;',
				'peace':'&#9774;',
				'yinyang':'&#9775;',
				'emoticon_from':'&#9785;',
				'emoticon_smile':'&#9786;',
				'female_sign':'&#9792;',
				'male_sign':'&#9794;',
				'spade':'&#9824;',
				'club':'&#9827;',
				'heart':'&#9829;',
				'diamond':'&#9830;',
				'note_quarter':'&#9833;',
				'note_eighth':'&#9834;',
				'note_eighth_beamed':'&#9835;',
				'note_sixteenth_beamed':'&#9836;',
				'music_flat':'&#9837;',
				'music_natural':'&#9838;',
				'music_sharp':'&#9839;',
				'scissors':'&#9986;',
				'airplane':'&#9992;',
				'envelope':'&#9993;',
				'pencil':'&#9999;',
				'check_mark':'&#10003;',
				'check_mark_bold':'&#10004;',
				'mult_x':'&#10005;',
				'mult_x_bold':'&#10006;',
				'ballot_x':'&#10007;',
				'ballot_x_bold':'&#10008;',
				'heart':'&#10084;',
				'floral_heart':'&#10086;',
				'arrow_1':'&#10132;',
				'arrow_2':'&#10137;',
				'arrow_3':'&#10140;',
				'arrow_4':'&#10141;',
				'arrow_5':'&#10146;',
				'arrow_6':'&#10147;',
				'arrow_7':'&#10148;',
				'arrow_8':'&#10153;',
				'arrow_9':'&#10154;'
			}
		}
	);
}