program parcial;
type
	RANGODIA = 1..31;
	compra = record
		codigoCliente : integer;
		dia: RANGODIA;
		cantProductos: integer;
		monto: real;
	end;
	
	
	compraL = record
		dia: RANGODIA;
		cantProductos: integer;
		monto: real;
	end;
	
	listaCompras = ^nodoLista;
	
	nodoLista = record
		elem: compraL;
		sig: listaCompras;
	end;
	
	compraA = record
		codigoCliente: integer;
		compras: listaCompras;
	end;
	
	arbolCompras = ^nodoArbol;
	nodoArbol = record
		elem: compraA;
		hi: arbolCompras;
		hd: arbolCompras;
	end;
	
	
procedure leerCompra (var c: compra);
begin
	c.codigoCliente := random (100);
	writeln ('CODIGO :', c.codigoCliente, '///////////////');
	c.dia := random (31);
	writeln ('DIA: ', c.dia);
	c.cantProductos := random (30);
	writeln ('CANTPRODUCTOS = ', c.cantProductos);
	c.monto := random (10000);
	writeln ('MONTO: ', c.monto:1:2);
	


end;		


procedure agregarAdelante (var pi: listaCompras; c: compra);
var
	nuevo: listaCompras;
begin
	new (nuevo);
	nuevo^.elem.dia := c.dia;
	nuevo^.elem.cantProductos := c.cantProductos;
	nuevo^.elem.monto := c.monto;
	nuevo^.sig := nil;
	if (pi = nil) then
		pi:= nuevo
	else
		begin
			nuevo^.sig := pi;
			pi := nuevo;
		
		
		end;




end;

procedure crearArbol (var a: arbolCompras; c: compra);
begin
	if (a = nil) then
		begin
			new(a);
			a^.elem.codigoCliente := c.codigoCliente;
			a^.elem.compras := nil;
			agregarAdelante (a^.elem.compras, c);
			a^.hi := nil;
			a^.hd := nil;
		
		
		end
	else
		begin
			if (a^.elem.codigoCliente = c.codigoCliente) then
				begin
					agregarAdelante (a^.elem.compras, c)
				
				end
			else if (c.codigoCliente <= a^.elem.codigoCliente) then
					crearArbol (a^.hi, c)
				else
					crearArbol (a^.hd, c);

		end;

end;

procedure cargarCompras (var a: arbolCompras);
var
	c: compra;
begin
	leerCompra (c);
	while (c.cantProductos <> 0) do
		begin
			crearArbol (a, c);
			leerCompra (c);
		
		
		end;
	


end;


function retornarComprasCliente (a: arbolCompras; codigo: integer): listaCompras;
begin
	if (a = nil) then
		retornarComprasCliente := nil
	else
		begin
			if (a^.elem.codigoCliente = codigo) then
				retornarComprasCliente := a^.elem.compras
			else if (codigo <= a^.elem.codigoCliente) then
					retornarComprasCliente := retornarComprasCliente (a^.hi, codigo)
				else
					retornarComprasCliente := retornarComprasCliente (a^.hd, codigo);
		
		
		end;


end;




procedure devolverMonto (pi: listaCompras; var maxMonto: real; var maxCant: integer);
begin
	if (pi = nil) then
		maxCant := -9999
	
	else
		begin
			devolverMonto (pi^.sig, maxMonto, maxCant);
			if (pi^.elem.cantProductos > maxCant) then
				begin
					maxCant := pi^.elem.cantProductos;
					maxMonto := pi^.elem.monto;
				
				end;
		
		
		end;





end;



function maxCant (pi: listaCompras) : listaCompras;

begin
	if (pi = nil) then
		maxCant := nil
	else
		begin
			if (pi^.sig = nil) then
				begin
					new (maxCant);
					maxCant := pi
				end
			else
				begin
					maxCant := maxCant (pi^.sig);
					if (pi^.elem.cantProductos > maxCant^.elem.cantProductos) then
						maxCant := pi;
				end;
		
		end;

end;


function monto (pi: listaCompras) : real;
var
	max : listaCompras;
begin
	max := maxCant (pi);
	if (max <> nil) then
		monto := max^.elem.monto
	else
		monto := -9999;
		



end;

var
	a: arbolCompras;
	cod: integer;
	maxMonto: real;

begin
	randomize;
	cargarCompras (a);
	writeln ('Ingrese un codigo de cliente a buscar las compras y luego devolver el monto de la compra con mayor cantidad de productos');
	readln (cod);
	writeln ('El monto de la compra con mayor cantidad de ventas del codigo ', cod, ' es ', monto (retornarComprasCliente (a, cod)):1:2);


end.
