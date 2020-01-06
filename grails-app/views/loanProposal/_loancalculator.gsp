
<p style="font-style: italic">Enter down payment and desired monthly payment below, and find out how much you may be able to borrow.</p>
<legend></legend>
<div id="interest-rate-form-group" class="fieldcontain form-group">
    <label class="control-label col-sm-4" for="interestRate">
        Annual Interest Rate (%) <span class="required-indicator">*</span>
    </label>
    <div class="col-sm-8">
        <g:field name="apr" value="7.5"  required="" class="form-control"/>
    </div>
</div>

<div id="termOfLoan-form-group"  class="fieldcontain form-group">
	<label class="control-label col-sm-4" for="amount">
	Term of Loan (Months):
	</label>
	<div class="col-sm-8">
        <g:field name="term" value="360" required="" class="form-control"/>
    </div>
</div>

<div id="downPayment-form-group"  class="fieldcontain form-group">
	<label class="control-label col-sm-4" for="amount">
		Down Payment: <span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8">
        <g:field  type="text" name="down" value="" required="" onkeyup="numberFormat();" class="form-control"/>
        
        
    </div>
</div>
<div id="desiredMonthlyPayment-form-group"  class="fieldcontain form-group">
	<label class="control-label col-sm-4" for="amount">
		Desired Monthly Payment: <span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8">
        <g:field name="pmt" value="" required="" onkeyup="numberFormat1();" class="form-control" />
    </div>
</div>



