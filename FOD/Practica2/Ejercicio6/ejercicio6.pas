program ejercicio6;
const
	
type
	infoDetalle = record
		codigoLocalidad: integer;
		codigoCepa: integer;
		activos: integer;
		nuevos: integer;
		recuperados: integer;
		fallecidos: integer;
	end;
	
	infoMaestro = record
		codigoLocalidad: integer;
		nombreLocalidad: string;
		codigoCepa: integer;
		nombreCepa: string;
		activos: integer;
		nuevos: integer;
		recuperados: integer;
		fallecidos: integer;	
	end;
		
	archivoDetalle = file of infoDetalle;
	vectorDetalles = array[1..2] of archivoDetalle;
	vectorRegistros = array [1..2] of infoDetalle;
	archivoMaestro = file of infoMaestro;
	
	
procedure leer (var archD : archivoDetalle; var i: infoDetalle);
begin
	if (not eof(archD)) then
		read (archD, i)
	else
		i.codigoLocalidad := 32000;
	
end;


procedure minimo (var vectorD: vectorDetalles; var vectorR: vectorRegistros; var min: infoDetalle);
var
	i, minIndice : integer;

begin
	min.codigoLocalidad := 32000;
	min.codigoCepa := 32000;
	for i := 1 to 2 do
		begin
			if (vectorR[i].codigoLocalidad < min.codigoLocalidad) then
				begin
					if (vectorR[i].codigoCepa <= min.codigoCepa) then
						begin
							minIndice := i;
							min = vectoR[i];
						
						end;
						
				
				
				end;
		
		
		end;
	
	
	
	leer (vectorD[minIndice], vectorR[minIndice]);



end;


procedure procesar (var vectorD: vectorDetalles; var vectorR: vectorRegistros; var maestro: archivoMaestro);
var
	min: infoDetalle;
	regMae: infoMaestro;
begin
	for i := 1 to 2 do
		begin
			reset (vectorD[i]);
			leer (vectorD[i], vectorR[i]);
		
		
		end;
		
	reset (maestro);
	read (meastro, regMae);
	
	minimo (vectorD, vectorR, min);
	while (min.codigoLocalidad <> VALORALTO) do
		begin
			while ((regMae.codigoLocalidad <> min.codigoLocalidad) and (regMae.codigoCepa <> min.codigoCepa)) do
				begin
					read (maestro, regMae);
				
				end;
				
				regMae.fallecidos := regMae.fallecidos + min.fallecidos;
				regMae.recuperados := regMae.recuperados + min.recuperados;
				regMae.activos := min.activos;
				regMae.nuevos := min.nuevos;
					
				seek (maestro, filePos(maestro) - 1);
				write (maestro, regMae);
				
				minimo(vectorD, vectorR, min)
					
		
		end;



end;



	
		
		
