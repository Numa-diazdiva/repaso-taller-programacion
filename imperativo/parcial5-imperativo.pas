program parcial5Imperativo;

Const
	CANT_SUCURSALES = 5;
	
Type
	tDia = 1..31;
	tMes = 1..12;
	tFecha = record
		dia: tDia;
		mes: tMes;
		anio: integer;
	end;
	
	subCodSuc = 1..CANT_SUCURSALES;
	
	tAsistencia = record
		codigoCliente: integer;
		dniCliente: integer;
		fecha: tFecha;
		minutosAsistidos: integer;
		codigoSucursal: subCodSuc;
	end;
	
	listaAsistencia = ^nodoAsistencia;
	nodoAsistencia = record
		dato: tAsistencia;
		sig: listaAsistencia;
	end;
	
	tAsistenciaSucursales = array[1..CANT_SUCURSALES] of listaAsistencia;
	
	tRegistroCliente = record
		dniCliente: integer;
		totalAsistenciasATodasLasSucursales: integer;
	end;

	arbol = ^nodoArbol;
	nodoArbol = record
		dato: tRegistroCliente;
		hi: arbol;
		hd: arbol;
	end;

procedure InicializarSucursales(var asistenciaSucursales: tAsistenciaSucursales);
	var
		i: integer;
	begin
		for i:= 1 to CANT_SUCURSALES do begin
			asistenciaSucursales[i]:= nil;
		end;
	end;

procedure LeerAsistencia(var asistencia: tAsistencia);
	begin
		read(asistencia.codigoCliente);
		if(asistencia.codigoCliente <> -1) then begin
			read(asistencia.dniCliente);
			read(asistencia.fecha.dia);
			read(asistencia.fecha.mes);
			read(asistencia.fecha.anio);
			read(asistencia.minutosAsistidos);
		end;
	end;

procedure InsertarOrdenado(var asistenciaSucursal: listaAsistencia; asistencia: tAsistencia);
	var
		aux,act,ant: listaAsistencia;
	begin
		new(aux);
		aux^.dato:= asistencia;
		act:= asistenciaSucursal;
		ant:= asistenciaSucursal;
		while((act <> nil) and (act^.dato.codigoCliente < asistencia.codigoCliente)) do begin
			ant:= act;
			act:= act^.sig;
		end;
		if ant = act then begin
			asistenciaSucursal:= aux;
			asistenciaSucursal^.sig:= act;
		end
		else begin
			aux^.sig:= act;
			ant^.sig:= aux;
		end; 
	end;

procedure IncorporarAsistencia(var asistenciaSucursales: tAsistenciaSucursales; asistencia: tAsistencia);
	var
		sucursal: integer;
	begin
		sucursal:= asistencia.codigoSucursal;
		InsertarOrdenado(asistenciaSucursales[sucursal], asistencia);
	end;

procedure CargarAsistencias(var asistenciaSucursales: tAsistenciaSucursales);
	var
		asistencia: tAsistencia;
	begin
		LeerAsistencia(asistencia);
		while(asistencia.codigoCliente <> -1) do
		begin
			IncorporarAsistencia(asistenciaSucursales, asistencia);
			LeerAsistencia(asistencia);
		end;
	end;

procedure Minimo(var asistenciaSucursales: tAsistenciaSucursales; var asistencia: tAsistencia);
	var
		i: integer;
		min: tAsistencia;
		iMin: integer;
	begin
		iMin:= -1;
		min.codigoCliente:= 32000;
		for i:= 1 to CANT_SUCURSALES do begin
			if((asistenciaSucursales[i] <> nil) and (asistenciaSucursales[i]^.dato.codigoCliente < min.codigoCliente)) then begin
				min:= asistenciaSucursales[i]^.dato;
				iMin:= i;
			end;
		end;
		if (iMin <> -1) then begin
			asistenciaSucursales[i]:= asistenciaSucursales[i]^.sig;
		end;
	end;

procedure Insertar(var arbol: arbol; cliente: tRegistroCliente);
	var
		aux: arbol;
	begin
		
		if (arbol <> nil) then begin
			if(arbol^.dato.dniCliente > cliente.dniCliente) then begin
				Insertar(arbol^.hi, cliente);
			end
			else begin
				Insertar(arbol^.hd, cliente);
			end;
		end
		else begin
			new(aux);
			aux^.dato:= cliente;
			aux^.hi:= nil;
			aux^.hd:= nil;
		end;
		
	end;

procedure MergeAsistencias(asistenciaSucursales: tAsistenciaSucursales; var arbolClientes: arbol);
	var
		asistenciaMin: tAsistencia;
		dniActual: integer;
		cantAsistenciasAct: integer;
		regArbol: tRegistroCliente;
	begin
		Minimo(asistenciaSucursales, asistenciaMin);
		while(asistenciaMin.codigoCliente <> 32000) do begin
			dniActual:= asistenciaMin.dniCliente;
			cantAsistenciasAct:= 0;
			while((asistenciaMin.codigoCliente <> 32000) and (asistenciaMin.dniCliente = dniActual)) do begin
				cantAsistenciasAct:= cantAsistenciasAct + 1;
				Minimo(asistenciaSucursales, asistenciaMin);
			end;
			regArbol.dniCliente:= dniActual;
			regArbol.totalAsistenciasATodasLasSucursales:= cantAsistenciasAct;
			Insertar(arbolClientes, regArbol);
		end;
	end;

Var
	asistenciaSucursales: tAsistenciaSucursales;
	arbolClientes: arbol;
Begin
	InicializarSucursales(asistenciaSucursales);
	arbolClientes:= nil;
	CargarAsistencias(asistenciaSucursales);
	MergeAsistencias(asistenciaSucursales, arbolClientes);
End.
		
