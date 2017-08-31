/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type DeclTemplateStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZL26AdoptTemplateParameterListPN5clang21TemplateParameterListEPNS_11DeclContextE;_ZL28GenerateInjectedTemplateArgsRN5clang10ASTContextEPNS_21TemplateParameterListEPNS_16TemplateArgumentE;_ZL33createMakeIntegerSeqParameterListRKN5clang10ASTContextEPNS_11DeclContextE;_ZL34createBuiltinTemplateParameterListRKN5clang10ASTContextEPNS_11DeclContextENS_19BuiltinTemplateKindE;_ZL34createTypePackElementParameterListRKN5clang10ASTContextEPNS_11DeclContextE; -static-type=DeclTemplateStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class DeclTemplateStatics {

//<editor-fold defaultstate="collapsed" desc="AdoptTemplateParameterList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 109,
 FQN="AdoptTemplateParameterList", NM="_ZL26AdoptTemplateParameterListPN5clang21TemplateParameterListEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZL26AdoptTemplateParameterListPN5clang21TemplateParameterListEPNS_11DeclContextE")
//</editor-fold>
public static void AdoptTemplateParameterList(TemplateParameterList /*P*/ Params, 
                          DeclContext /*P*/ Owner) {
  for (NamedDecl /*P*/ P : $Deref(Params)) {
    P.setDeclContext(Owner);
    {
      
      TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(P);
      if ((TTP != null)) {
        AdoptTemplateParameterList(TTP.getTemplateParameters(), Owner);
      }
    }
  }
}


/// \brief Generate the injected template arguments for the given template
/// parameter list, e.g., for the injected-class-name of a class template.
//<editor-fold defaultstate="collapsed" desc="GenerateInjectedTemplateArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 202,
 FQN="GenerateInjectedTemplateArgs", NM="_ZL28GenerateInjectedTemplateArgsRN5clang10ASTContextEPNS_21TemplateParameterListEPNS_16TemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZL28GenerateInjectedTemplateArgsRN5clang10ASTContextEPNS_21TemplateParameterListEPNS_16TemplateArgumentE")
//</editor-fold>
public static void GenerateInjectedTemplateArgs(final ASTContext /*&*/ Context, 
                            TemplateParameterList /*P*/ Params, 
                            type$ptr<TemplateArgument/*P*/> Args) {
  for (NamedDecl /*P*/ Param : $Deref(Params)) {
    TemplateArgument Arg/*J*/= new TemplateArgument();
    {
      TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(Param);
      if ((TTP != null)) {
        QualType ArgType = Context.getTypeDeclType(TTP);
        if (TTP.isParameterPack()) {
          ArgType.$assignMove(Context.getPackExpansionType(new QualType(ArgType), new OptionalUInt(None)));
        }
        
        Arg.$assignMove(new TemplateArgument(new QualType(ArgType)));
      } else {
        NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(Param);
        if ((NTTP != null)) {
          /*FIXME:NEW_EXPR [clang::Stmt::operator new] NM=_ZN5clang4StmtnwEjRKNS_10ASTContextEj*/
          Expr /*P*/ E = Stmt.$new_uint_ASTContext$C$P_uint(Context, (type$ptr<?> Mem)->
          /*new (Context)*/ new DeclRefExpr(NTTP, /*enclosing*/ false, 
              NTTP.getType().getNonLValueExprType(Context), 
              Expr.getValueKindForType(NTTP.getType()), 
              NTTP.getLocation())
          );
          if (NTTP.isParameterPack()) {
            E = /*FIXME:NEW_EXPR [clang::Stmt::operator new] NM=_ZN5clang4StmtnwEjRKNS_10ASTContextEj*/
            /*new (Context)*/ new PackExpansionExpr(Context.DependentTy.$QualType(), E, 
                NTTP.getLocation(), new OptionalUInt(None));
          }
          Arg.$assignMove(new TemplateArgument(E));
        } else {
          TemplateTemplateParmDecl /*P*/ TTP$1 = cast_TemplateTemplateParmDecl(Param);
          if (TTP$1.isParameterPack()) {
            Arg.$assignMove(new TemplateArgument(new TemplateName(TTP$1), new OptionalUInt()));
          } else {
            Arg.$assignMove(new TemplateArgument(new TemplateName(TTP$1)));
          }
        }
      }
    }
    if (Param.isTemplateParameterPack()) {
      Arg.$assignMove(TemplateArgument.CreatePackCopy(Context, new ArrayRef<TemplateArgument>(Arg, false)));
    }
    
    Args.$postInc().$star().$assign(Arg);
  }
}

//<editor-fold defaultstate="collapsed" desc="createMakeIntegerSeqParameterList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1153,
 FQN="createMakeIntegerSeqParameterList", NM="_ZL33createMakeIntegerSeqParameterListRKN5clang10ASTContextEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZL33createMakeIntegerSeqParameterListRKN5clang10ASTContextEPNS_11DeclContextE")
//</editor-fold>
public static TemplateParameterList /*P*/ createMakeIntegerSeqParameterList(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC) {
  // typename T
  TemplateTypeParmDecl /*P*/ T = TemplateTypeParmDecl.Create(C, DC, new SourceLocation(), new SourceLocation(), /*Depth=*/ 1, /*Position=*/ 0, 
      /*Id=*/ (IdentifierInfo /*P*/ )null, /*Typename=*/ true, /*ParameterPack=*/ false);
  T.setImplicit(true);
  
  // T ...Ints
  TypeSourceInfo /*P*/ TI = C.getTrivialTypeSourceInfo(new QualType(T.getTypeForDecl(), 0));
  NonTypeTemplateParmDecl /*P*/ N = NonTypeTemplateParmDecl.Create(C, DC, new SourceLocation(), new SourceLocation(), /*Depth=*/ 0, /*Position=*/ 1, 
      /*Id=*/ (IdentifierInfo /*P*/ )null, TI.getType(), /*ParameterPack=*/ true, TI);
  N.setImplicit(true);
  
  // <typename T, T ...Ints>
  NamedDecl /*P*/ P[/*2*/] = new NamedDecl /*P*/ [/*2*/] {T, N};
  TemplateParameterList /*P*/ TPL = TemplateParameterList.Create(C, new SourceLocation(), new SourceLocation(), new ArrayRef<NamedDecl /*P*/ >(P, true), new SourceLocation());
  
  // template <typename T, ...Ints> class IntSeq
  TemplateTemplateParmDecl /*P*/ TemplateTemplateParm = TemplateTemplateParmDecl.Create(C, DC, new SourceLocation(), /*Depth=*/ 0, /*Position=*/ 0, 
      /*ParameterPack=*/ false, /*Id=*/ (IdentifierInfo /*P*/ )null, TPL);
  TemplateTemplateParm.setImplicit(true);
  
  // typename T
  TemplateTypeParmDecl /*P*/ TemplateTypeParm = TemplateTypeParmDecl.Create(C, DC, new SourceLocation(), new SourceLocation(), /*Depth=*/ 0, /*Position=*/ 1, 
      /*Id=*/ (IdentifierInfo /*P*/ )null, /*Typename=*/ true, /*ParameterPack=*/ false);
  TemplateTypeParm.setImplicit(true);
  
  // T N
  TypeSourceInfo /*P*/ TInfo = C.getTrivialTypeSourceInfo(new QualType(TemplateTypeParm.getTypeForDecl(), 0));
  NonTypeTemplateParmDecl /*P*/ NonTypeTemplateParm = NonTypeTemplateParmDecl.Create(C, DC, new SourceLocation(), new SourceLocation(), /*Depth=*/ 0, /*Position=*/ 2, 
      /*Id=*/ (IdentifierInfo /*P*/ )null, TInfo.getType(), /*ParameterPack=*/ false, TInfo);
  NamedDecl /*P*/ Params[/*3*/] = new NamedDecl /*P*/ [/*3*/] {
    TemplateTemplateParm, TemplateTypeParm, 
    NonTypeTemplateParm};
  
  // template <template <typename T, T ...Ints> class IntSeq, typename T, T N>
  return TemplateParameterList.Create(C, new SourceLocation(), new SourceLocation(), 
      new ArrayRef<NamedDecl /*P*/ >(Params, true), new SourceLocation());
}

//<editor-fold defaultstate="collapsed" desc="createTypePackElementParameterList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1200,
 FQN="createTypePackElementParameterList", NM="_ZL34createTypePackElementParameterListRKN5clang10ASTContextEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZL34createTypePackElementParameterListRKN5clang10ASTContextEPNS_11DeclContextE")
//</editor-fold>
public static TemplateParameterList /*P*/ createTypePackElementParameterList(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC) {
  // std::size_t Index
  TypeSourceInfo /*P*/ TInfo = C.getTrivialTypeSourceInfo(C.getSizeType().$QualType());
  NonTypeTemplateParmDecl /*P*/ Index = NonTypeTemplateParmDecl.Create(C, DC, new SourceLocation(), new SourceLocation(), /*Depth=*/ 0, /*Position=*/ 0, 
      /*Id=*/ (IdentifierInfo /*P*/ )null, TInfo.getType(), /*ParameterPack=*/ false, TInfo);
  
  // typename ...T
  TemplateTypeParmDecl /*P*/ Ts = TemplateTypeParmDecl.Create(C, DC, new SourceLocation(), new SourceLocation(), /*Depth=*/ 0, /*Position=*/ 1, 
      /*Id=*/ (IdentifierInfo /*P*/ )null, /*Typename=*/ true, /*ParameterPack=*/ true);
  Ts.setImplicit(true);
  
  // template <std::size_t Index, typename ...T>
  NamedDecl /*P*/ Params[/*2*/] = new NamedDecl /*P*/ [/*2*/] {Index, Ts};
  return TemplateParameterList.Create(C, new SourceLocation(), new SourceLocation(), 
      llvm.makeArrayRef(Params), 
      new SourceLocation());
}

//<editor-fold defaultstate="collapsed" desc="createBuiltinTemplateParameterList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1221,
 FQN="createBuiltinTemplateParameterList", NM="_ZL34createBuiltinTemplateParameterListRKN5clang10ASTContextEPNS_11DeclContextENS_19BuiltinTemplateKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZL34createBuiltinTemplateParameterListRKN5clang10ASTContextEPNS_11DeclContextENS_19BuiltinTemplateKindE")
//</editor-fold>
public static TemplateParameterList /*P*/ createBuiltinTemplateParameterList(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, BuiltinTemplateKind BTK) {
  switch (BTK) {
   case BTK__make_integer_seq:
    return createMakeIntegerSeqParameterList(C, DC);
   case BTK__type_pack_element:
    return createTypePackElementParameterList(C, DC);
  }
  throw new llvm_unreachable("unhandled BuiltinTemplateKind!");
}

} // END OF class DeclTemplateStatics
