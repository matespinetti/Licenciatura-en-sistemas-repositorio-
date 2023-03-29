program ejercicio3;
const
	VALORALTO = 32000;
type
	producto = record
		codigo: integer;
		nombre: string;
		descripcion: string;
		stockD: integer;
		stockM: integer;
		precio: real;
	end;
	
	
	regDetalle= record
		codigo: integer;
		cantVendida: integer;
	end;
	
	
	archivoM = file of producto;
	archivoD = file of regDetalle;
	vector = array[1..30] of archivoD;
	vReg = array [1..30] of regDetalle;
	

var
	vectorD : vector;
	archM: archivoM;




procedure leer (var archD: archivoD; var regD: regDetalle);
begin
	if (not eof(archD)) then
		read (archD, regD)
	else
		regD.codigo := VALORALTO;


end;

procedure minimo (var vectorD: vector; var vReg: vReg; var min: regDetalle );
var
	indiceMin, i: integer;
begin
	min.codigo := VALORALTO;
	for (i := 1 to 30) do
		begin
			if (vReg [i].codigo < min.codigo) then
				begin
					indiceMin := i;
					min := vReg[i]
				
				end;
		
		
		end;
		
	
	leer (vectorD[indiceMin], vReg[indiceMin]);


end;
procedure procesar (var vectorD: vector; var archM: archivoM );
var
	i: integer;
	vReg : vReg;
	min: regDetalle;
	regM: producto;
	actual, total: integer;
begin
	reset (archM);
	read (archM, regM )
	for i := 1 to 30 do
		begin
		reset (vectorD[i]);
		leer(vectorD[i], vReg[i]);
		end;
	
	minimo (vectorD, vReg, min);
	while (min.codigo <> VALORALTO) do
		begin
			actual := min.codigo;
			total := 0;
			while ((min.codigo <> VALORALTO) and(actual = min.codigo)) do
				begin
					total := total + min.cantVendidos;
					minimo (vectorD, vReg, min);
				
				end;
				
			while (regM.codigo <> actual) do
				begin
					read (archM, regM)
				
				end;
			seek (archM, filePos(archM) - 1);
			regM.stockD := regM.stockD - total;
			write (archM, regM);
			
		
		
		end;
	
	
	
	
		
	
	
	



end;
