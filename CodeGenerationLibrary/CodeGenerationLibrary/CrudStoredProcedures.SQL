create procedure Products
	@ProductID int
as
	delete from Products
	where
		ProductID = @ProductID

