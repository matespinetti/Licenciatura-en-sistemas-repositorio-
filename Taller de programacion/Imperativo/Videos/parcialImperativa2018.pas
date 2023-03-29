program parcialImperativo2019;

type
	f = record
		dia: integer;
		mes: integer;
		ano: integer;
	end;
	
	cliente = record
		dni: integer;
		nombre: string;
	end;
	
	infoPedido= record
		fecha: f;
		monto: real;
	end;
	
	
	listaPedidos = ^nodoLista;
	nodoLista = record
		elem: infoPedido;
		sig: listaPedidos;
	end;
	
	
	pedidoA = record
		dni: integer;
		nombre: string;
		pedidos: listaPedidos;
	end;
	
	
	arbolPedidos = ^nodoArbol;
	nodoArbol = record
		elem: pedidoA;
		hi: arbolPedidos;
		hd: arbolPedidos;
	end;
	
	
procedure leerFecha (var fec: f);
begin
	writeln ('Ingrese el dia del pedido');
	readln (fec.dia);
	writeln ('Ingrese el mes del pedido');
	readln (fec.mes);
	writeln ('Ingrese el ano del pedido');
	readln (fec.ano);


end;

procedure leerCliente (var c: cliente);
begin
	writeln ('Ingrese el dni del cliente');
	readln (c.dni);
	writeln ('Ingrese el nombre del cliente');
	readln (c.nombre);

end;



procedure leerInfoPedido (var i:infoPedido);
begin
	leerfecha (i.fecha);
	writeln ('Ingrese el monto del pedido');
	readln (i.monto);

end;

procedure agregarAdelante (var pi: listaPedidos; i: infoPedido);
var
	nuevo: listaPedidos;
begin
	new (nuevo);
	nuevo^.elem := i;
	nuevo^.sig := nil;
	
	if (pi = nil) then
		pi:= nuevo
	else
		begin
			nuevo^.sig := pi;
			pi := nuevo;
		
		end;


end;

procedure crearArbol (var a: arbolPedidos; c: cliente; i: infoPedido);
begin
	if (a = nil) then
		begin
			new (a);
			a^.elem.dni := c.dni;
			a^.elem.nombre := c.nombre;
			a^.elem.pedidos := nil;
			agregarAdelante (a^.elem.pedidos, i);
			a^.hi := nil;
			a^.hd := nil;
		
		
		
		
		
		end
	else
		begin
			if (c.dni = a^.elem.dni) then
				begin
					agregarAdelante (a^.elem.pedidos, i);
				
				
				end
			else if (c.dni < a^.elem.dni) then
					crearArbol (a^.hi, c, i)
				else
					crearArbol (a^.hd, c, i);
		
		
		
		
		
		end;











end;



procedure cargarPedidos (var a: arbolPedidos);
var
	c: cliente;
	i: infoPedido;
begin
	leerCliente (c);
	leerInfoPedido (i);
	while (i.monto <> 0) do
		begin
			crearArbol (a, c, i);
			leerCliente (c);
			leerInfoPedido (i);
		
		
		end;




end;


function fechasSonIguales (fecha1: f; fecha2: f): boolean;
begin
	fechasSonIguales := ((fecha1.dia = fecha2.dia) and (fecha1.mes = fecha2.mes) and (fecha1.ano = fecha2.ano))


end;

procedure recorrerListaPedidos (pi: listaPedidos; fecha: f; var cant: integer);
begin
	while (pi <> nil) do
		begin
			if (fechasSonIguales (pi^.elem.fecha, fecha)) then
				cant := cant +1;
			
			pi := pi^.sig;
		
		
		end;




end;
procedure cantFecha (a: arbolPedidos; fecha: f; var cant: integer);
begin
	if (a<> nil) then
		begin
			cantFecha (a^.hi, fecha, cant);
			recorrerListaPedidos (a^.elem.pedidos, fecha, cant);
			cantFecha (a^.hd, fecha, cant);
		
		
		end;





end;



var
	a: arbolPedidos;
	fecha: f;
	cant: integer;

begin
	cant := 0;
	cargarPedidos (a);
	writeln ('Ingrese una fecha para buscar para buscar la cantidad de clientes que realizaron pedidos');
	leerFecha (fecha);
	cantFecha (a, fecha, cant);
	writeln ('La cantidad de productos vendidos en la fecha ingresada es de ', cant );
	




end.
