program ejercicio5;
const
	VALORALTO = 9999;
type
	nacimiento= record
		partida : integer;
		nombre: string;
		apellido: string;
		direccion: string;
		matriculaMed: integer;
		nombreMadre: string;
		apellidoMadre: string;
		dniMadre: integer;
		nombrePadre: string;
		apellidoPadre: string;
		dniPadre: integer;
	end;
	
	fallecimiento = record
		partida: integer;
		dni: integer;
		nombre: string;
		apellido: string;
		matriculaMed: integer;
		fecha: string;
		hora: string;
		lugar: string;
	end;
	
	regMaestro = record
		partida : integer;
		nombre: string;
		apellido: string;
		direccion: string;
		matriculaMed: integer;
		nombreMadre: string;
		apellidoMadre: string;
		dniMadre: integer;
		nombrePadre: string;
		apellidoPadre: string;
		dniPadre: integer;
		fallecio : boolean;
		fecha: string;
		hora: string;
		lugar: string;
	end;
		
	
	
	archivoNac = file of nacimiento;
	archivoFac = file of fallecimiento;
	vectorArchN = array [1..50] of archivoNac;
	vectorarchF = array [1..50] of vectorFac;
	vectorNac= array [1..50] of nacimiento;
	vectorFac = array[1..50] of fallecimiento;
	maestro = file of regMaestro;




procedure leerNac (var varchN: vectorArchN; var vNac: vectorNac);
begin
	if (not eof (vArchN)) then
		leer (vArchN, vNac)
	else
		vNac.partida := VALORALTO;


end;

procedure leerFac (var vArchF: vectorarchF; var vFac: vectorFac);
begin
	if (not eof(vArchF)) then
		leer (vArchF, vFac)
	else
		vFac.codigo := VALORALTO;


end;

procedure minimoNac (var varchN: vectorArchN; var vNac: vectorNac; var min: regMaestro );
var
	i, minIndice, minIndice: integer;
begin
	min.codigo := VALORALTO;
	for i := 1 to 50 do
		begin
			if (vNac[i] <= min.codigo) then
				begin
					min := vNac[i];
					minIndice := i;
					
				end;
				
				
				leer (varchN[minIndice], vNac[minIndice]);
				
		end;



end;
procedure procesar (var vArchN: vectorArchN; var vArchF: vectorarchF; var archM: maestro; var vNac: vectorNac; var vFac: vectorFac)
var
	min: regMaestro;
	i: integer;
begin
	for i := 1 to 50 do
		begin
			reset (vArchN[i]);
			reset (vArchF[i]);
			leer (vArchN[i], vNac[i]);
			leer (vArchF[i], vFac[i]);
	
		end;
		
	rewrite (archM);
	
		
	








end;
	
	
		
	

		
