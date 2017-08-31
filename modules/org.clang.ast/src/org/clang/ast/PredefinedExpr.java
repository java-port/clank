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

package org.clang.ast;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.QualType.StreamedQualTypeHelper.*;


/// \brief [C99 6.4.2.2] - A predefined identifier such as __func__.
//<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1160,
 FQN="clang::PredefinedExpr", NM="_ZN5clang14PredefinedExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExprE")
//</editor-fold>
public class PredefinedExpr extends /*public*/ Expr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::IdentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1162,
   FQN="clang::PredefinedExpr::IdentType", NM="_ZN5clang14PredefinedExpr9IdentTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExpr9IdentTypeE")
  //</editor-fold>
  public enum IdentType implements Native.ComparableLower {
    Func(0),
    Function(Func.getValue() + 1),
    LFunction(Function.getValue() + 1), // Same as Function, but as wide string.
    FuncDName(LFunction.getValue() + 1),
    FuncSig(FuncDName.getValue() + 1),
    PrettyFunction(FuncSig.getValue() + 1),
    /// \brief The same as PrettyFunction, except that the
    /// 'virtual' keyword is omitted for virtual member functions.
    PrettyFunctionNoVirtual(PrettyFunction.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IdentType valueOf(int val) {
      IdentType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IdentType[] VALUES;
      private static final IdentType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IdentType kind : IdentType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IdentType[min < 0 ? (1-min) : 0];
        VALUES = new IdentType[max >= 0 ? (1+max) : 0];
        for (IdentType kind : IdentType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private IdentType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((IdentType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((IdentType)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private SourceLocation Loc;
  /*friend*/public IdentType Type;
  /*friend*/public Stmt /*P*/ FnName;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::PredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 438,
   FQN="clang::PredefinedExpr::PredefinedExpr", NM="_ZN5clang14PredefinedExprC1ENS_14SourceLocationENS_8QualTypeENS0_9IdentTypeEPNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExprC1ENS_14SourceLocationENS_8QualTypeENS0_9IdentTypeEPNS_13StringLiteralE")
  //</editor-fold>
  public PredefinedExpr(SourceLocation L, QualType FNTy, IdentType IT, 
      StringLiteral /*P*/ SL) {
    // : Expr(PredefinedExprClass, FNTy, VK_LValue, OK_Ordinary, FNTy->isDependentType(), FNTy->isDependentType(), FNTy->isInstantiationDependentType(), /*ContainsUnexpandedParameterPack=*/ false), Loc(L), Type(IT), FnName(SL) 
    //START JInit
    super(StmtClass.PredefinedExprClass, new QualType(FNTy), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, 
        FNTy.$arrow().isDependentType(), FNTy.$arrow().isDependentType(), 
        FNTy.$arrow().isInstantiationDependentType(), 
        false);
    this.Loc = new SourceLocation(L);
    this.Type = IT;
    this.FnName = SL;
    //END JInit
  }

  
  /// \brief Construct an empty predefined expression.
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::PredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1184,
   FQN="clang::PredefinedExpr::PredefinedExpr", NM="_ZN5clang14PredefinedExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ PredefinedExpr(EmptyShell Empty) {
    // : Expr(PredefinedExprClass, Empty), Loc(), Type(Func), FnName(null) 
    //START JInit
    super(StmtClass.PredefinedExprClass, new EmptyShell(Empty));
    this.Loc = new SourceLocation();
    this.Type = IdentType.Func;
    this.FnName = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::getIdentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1187,
   FQN="clang::PredefinedExpr::getIdentType", NM="_ZNK5clang14PredefinedExpr12getIdentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14PredefinedExpr12getIdentTypeEv")
  //</editor-fold>
  public IdentType getIdentType() /*const*/ {
    return Type;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1189,
   FQN="clang::PredefinedExpr::getLocation", NM="_ZNK5clang14PredefinedExpr11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14PredefinedExpr11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1190,
   FQN="clang::PredefinedExpr::setLocation", NM="_ZN5clang14PredefinedExpr11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExpr11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation L) {
    Loc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::getFunctionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 446,
   FQN="clang::PredefinedExpr::getFunctionName", NM="_ZN5clang14PredefinedExpr15getFunctionNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExpr15getFunctionNameEv")
  //</editor-fold>
  public StringLiteral /*P*/ getFunctionName() {
    return cast_or_null_StringLiteral(FnName);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::getFunctionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1193,
   FQN="clang::PredefinedExpr::getFunctionName", NM="_ZNK5clang14PredefinedExpr15getFunctionNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14PredefinedExpr15getFunctionNameEv")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getFunctionName$Const() /*const*/ {
    return ((/*const_cast*/PredefinedExpr /*P*/ )(this)).getFunctionName();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::getIdentTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 450,
   FQN="clang::PredefinedExpr::getIdentTypeName", NM="_ZN5clang14PredefinedExpr16getIdentTypeNameENS0_9IdentTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExpr16getIdentTypeNameENS0_9IdentTypeE")
  //</editor-fold>
  public static StringRef getIdentTypeName(PredefinedExpr.IdentType IT) {
    switch (IT) {
     case Func:
      return new StringRef(/*KEEP_STR*/$__func__);
     case Function:
      return new StringRef(/*KEEP_STR*/$__FUNCTION__);
     case FuncDName:
      return new StringRef(/*KEEP_STR*/$__FUNCDNAME__);
     case LFunction:
      return new StringRef(/*KEEP_STR*/$L__FUNCTION__);
     case PrettyFunction:
      return new StringRef(/*KEEP_STR*/$__PRETTY_FUNCTION__);
     case FuncSig:
      return new StringRef(/*KEEP_STR*/$__FUNCSIG__);
     case PrettyFunctionNoVirtual:
      break;
    }
    throw new llvm_unreachable("Unknown ident type for PredefinedExpr");
  }

  
  // FIXME: Maybe this should use DeclPrinter with a special "print predefined
  // expr" policy instead.
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::ComputeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 472,
   FQN="clang::PredefinedExpr::ComputeName", NM="_ZN5clang14PredefinedExpr11ComputeNameENS0_9IdentTypeEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExpr11ComputeNameENS0_9IdentTypeEPKNS_4DeclE")
  //</editor-fold>
  public static std.string ComputeName(IdentType IT, /*const*/ Decl /*P*/ CurrentDecl) {
    final ASTContext /*&*/ Context = CurrentDecl.getASTContext();
    if (IT == PredefinedExpr.IdentType.FuncDName) {
      {
        /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(CurrentDecl);
        if ((ND != null)) {
          std.unique_ptr<MangleContext> MC = null;
          try {
            MC/*J*/= new std.unique_ptr<MangleContext>();
            MC.reset(Context.createMangleContext());
            if (MC.$arrow().shouldMangleDeclName(ND)) {
              raw_svector_ostream Out = null;
              try {
                SmallString/*256*/ Buffer/*J*/= new SmallString/*256*/(256);
                Out/*J*/= new raw_svector_ostream(Buffer);
                {
                  /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(ND);
                  if ((CD != null)) {
                    MC.$arrow().mangleCXXCtor(CD, CXXCtorType.Ctor_Base, Out);
                  } else {
                    /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(ND);
                    if ((DD != null)) {
                      MC.$arrow().mangleCXXDtor(DD, CXXDtorType.Dtor_Base, Out);
                    } else {
                      MC.$arrow().mangleName(ND, Out);
                    }
                  }
                }
                if (!Buffer.empty() && Buffer.front() == $$SOH) {
                  return Buffer.substr(1).$string();
                }
                return Buffer.str().$string();
              } finally {
                if (Out != null) { Out.$destroy(); }
              }
            } else {
              return ND.getIdentifier().getName().$string();
            }
          } finally {
            if (MC != null) { MC.$destroy(); }
          }
        }
      }
      return new std.string(/*KEEP_STR*/$EMPTY);
    }
    {
      /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(CurrentDecl);
      if ((BD != null)) {
        std.unique_ptr<MangleContext> MC = null;
        raw_svector_ostream Out = null;
        try {
          MC/*J*/= new std.unique_ptr<MangleContext>();
          MC.reset(Context.createMangleContext());
          SmallString/*256*/ Buffer/*J*/= new SmallString/*256*/(256);
          Out/*J*/= new raw_svector_ostream(Buffer);
          /*const*/ DeclContext /*P*/ DC = CurrentDecl.getDeclContext$Const();
          if (DC.isFileContext()) {
            MC.$arrow().mangleGlobalBlock(BD, /*ID*/ (/*const*/ NamedDecl /*P*/ )null, Out);
          } else {
            /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(DC);
            if ((CD != null)) {
              MC.$arrow().mangleCtorBlock(CD, /*CT*/ CXXCtorType.Ctor_Complete, BD, Out);
            } else {
              /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(DC);
              if ((DD != null)) {
                MC.$arrow().mangleDtorBlock(DD, /*DT*/ CXXDtorType.Dtor_Complete, BD, Out);
              } else {
                MC.$arrow().mangleBlock(DC, BD, Out);
              }
            }
          }
          return Out.str().$string();
        } finally {
          if (Out != null) { Out.$destroy(); }
          if (MC != null) { MC.$destroy(); }
        }
      }
    }
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CurrentDecl);
      if ((FD != null)) {
        raw_svector_ostream Out = null;
        raw_string_ostream POut = null;
        raw_string_ostream TOut = null;
        try {
          if (IT != IdentType.PrettyFunction && IT != IdentType.PrettyFunctionNoVirtual && IT != IdentType.FuncSig) {
            return FD.getNameAsString();
          }
          
          SmallString/*256*/ Name/*J*/= new SmallString/*256*/(256);
          Out/*J*/= new raw_svector_ostream(Name);
          {
            
            /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
            if ((MD != null)) {
              if (MD.isVirtual() && IT != IdentType.PrettyFunctionNoVirtual) {
                Out.$out(/*KEEP_STR*/"virtual ");
              }
              if (MD.isStatic()) {
                Out.$out(/*KEEP_STR*/"static ");
              }
            }
          }
          
          PrintingPolicy Policy/*J*/= new PrintingPolicy(Context.getLangOpts());
          std.string Proto/*J*/= new std.string();
          POut/*J*/= new raw_string_ostream(Proto);
          
          /*const*/ FunctionDecl /*P*/ Decl = FD;
          {
            /*const*/ FunctionDecl /*P*/ Pattern = FD.getTemplateInstantiationPattern();
            if ((Pattern != null)) {
              Decl = Pattern;
            }
          }
          /*const*/ FunctionType /*P*/ AFT = Decl.getType().$arrow().getAs(FunctionType.class);
          /*const*/ FunctionProtoType /*P*/ FT = null;
          if (FD.hasWrittenPrototype()) {
            FT = dyn_cast_FunctionProtoType(AFT);
          }
          if (IT == IdentType.FuncSig) {
            switch (FT.getCallConv()) {
             case CC_C:
              POut.$out(/*KEEP_STR*/"__cdecl ");
              break;
             case CC_X86StdCall:
              POut.$out(/*KEEP_STR*/"__stdcall ");
              break;
             case CC_X86FastCall:
              POut.$out(/*KEEP_STR*/"__fastcall ");
              break;
             case CC_X86ThisCall:
              POut.$out(/*KEEP_STR*/"__thiscall ");
              break;
             case CC_X86VectorCall:
              POut.$out(/*KEEP_STR*/"__vectorcall ");
              break;
             default:
              // Only bother printing the conventions that MSVC knows about.
              break;
            }
          }
          
          FD.printQualifiedName(POut, Policy);
          
          POut.$out(/*KEEP_STR*/$LPAREN);
          if ((FT != null)) {
            for (/*uint*/int i = 0, e = Decl.getNumParams(); i != e; ++i) {
              if ((i != 0)) {
                POut.$out(/*KEEP_STR*/$COMMA_SPACE);
              }
              $out_raw_ostream_StreamedQualTypeHelper$C(POut, Decl.getParamDecl$Const(i).getType().stream(Policy));
            }
            if (FT.isVariadic()) {
              if ((FD.getNumParams() != 0)) {
                POut.$out(/*KEEP_STR*/$COMMA_SPACE);
              }
              POut.$out(/*KEEP_STR*/$ELLIPSIS);
            }
          }
          POut.$out(/*KEEP_STR*/$RPAREN);
          {
            
            /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
            if ((MD != null)) {
              /*const*/ FunctionType /*P*/ FT$1 = MD.getType().$arrow().castAs(FunctionType.class);
              if (FT$1.isConst()) {
                POut.$out(/*KEEP_STR*/" const");
              }
              if (FT$1.isVolatile()) {
                POut.$out(/*KEEP_STR*/" volatile");
              }
              RefQualifierKind Ref = MD.getRefQualifier();
              if (Ref == RefQualifierKind.RQ_LValue) {
                POut.$out(/*KEEP_STR*/" &");
              } else if (Ref == RefQualifierKind.RQ_RValue) {
                POut.$out(/*KEEP_STR*/" &&");
              }
            }
          }
          
          /*typedef SmallVector<const ClassTemplateSpecializationDecl *, 8> SpecsTy*/
  //        final class SpecsTy extends SmallVector</*const*/ ClassTemplateSpecializationDecl /*P*/ >{ };
          SmallVector</*const*/ ClassTemplateSpecializationDecl /*P*/ > Specs/*J*/= new SmallVector</*const*/ ClassTemplateSpecializationDecl /*P*/ >(8, (/*const*/ ClassTemplateSpecializationDecl /*P*/ )null);
          /*const*/ DeclContext /*P*/ Ctx = FD.getDeclContext$Const();
          while ((Ctx != null) && isa_NamedDecl(Ctx)) {
            /*const*/ ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(Ctx);
            if ((Spec != null) && !Spec.isExplicitSpecialization()) {
              Specs.push_back(Spec);
            }
            Ctx = Ctx.getParent$Const();
          }
          
          std.string TemplateParams/*J*/= new std.string();
          TOut/*J*/= new raw_string_ostream(TemplateParams);
          for (std.reverse_iterator</*const*/ ClassTemplateSpecializationDecl /*P*/ > I = Specs.rbegin(), E = Specs.rend();
               $noteq_reverse_iterator$C(I, E); I.$preInc()) {
            /*const*/ TemplateParameterList /*P*/ Params = (I.$star()).getSpecializedTemplate().getTemplateParameters();
            final /*const*/ TemplateArgumentList /*&*/ Args = (I.$star()).getTemplateArgs();
            assert (Params.size() == Args.size());
            for (/*uint*/int i = 0, numParams = Params.size(); i != numParams; ++i) {
              StringRef Param = Params.getParam$Const(i).getName();
              if (Param.empty()) {
                continue;
              }
              TOut.$out(/*NO_COPY*/Param).$out(/*KEEP_STR*/" = ");
              Args.get(i).print(Policy, TOut);
              TOut.$out(/*KEEP_STR*/$COMMA_SPACE);
            }
          }
          
          FunctionTemplateSpecializationInfo /*P*/ FSI = FD.getTemplateSpecializationInfo();
          if ((FSI != null) && !FSI.isExplicitSpecialization()) {
            /*const*/ TemplateParameterList /*P*/ Params = FSI.getTemplate().getTemplateParameters();
            /*const*/ TemplateArgumentList /*P*/ Args = FSI.TemplateArguments;
            assert (Params.size() == Args.size());
            for (/*uint*/int i = 0, e = Params.size(); i != e; ++i) {
              StringRef Param = Params.getParam$Const(i).getName();
              if (Param.empty()) {
                continue;
              }
              TOut.$out(/*NO_COPY*/Param).$out(/*KEEP_STR*/" = ");
              Args.get(i).print(Policy, TOut);
              TOut.$out(/*KEEP_STR*/$COMMA_SPACE);
            }
          }
          
          TOut.flush();
          if (!TemplateParams.empty()) {
            // remove the trailing comma and space
            TemplateParams.resize(TemplateParams.size() - 2);
            POut.$out(/*KEEP_STR*/" [").$out(TemplateParams).$out(/*KEEP_STR*/$RSQUARE);
          }
          
          POut.flush();
          
          // Print "auto" for all deduced return types. This includes C++1y return
          // type deduction and lambdas. For trailing return types resolve the
          // decltype expression. Otherwise print the real type when this is
          // not a constructor or destructor.
          if (isa_CXXMethodDecl(FD)
             && cast_CXXMethodDecl(FD).getParent$Const().isLambda()) {
            Proto.$assignMove($add_T$C$P_string$C(/*KEEP_STR*/"auto ", Proto));
          } else if ((FT != null) && (FT.getReturnType().$arrow().getAs(DecltypeType.class) != null)) {
            FT.getReturnType().$arrow().getAs(DecltypeType.class).
                getUnderlyingType().
                getAsStringInternal(Proto, Policy);
          } else if (!isa_CXXConstructorDecl(FD) && !isa_CXXDestructorDecl(FD)) {
            AFT.getReturnType().getAsStringInternal(Proto, Policy);
          }
          
          Out.$out(Proto);
          
          return Name.str().str();
        } finally {
          if (TOut != null) { TOut.$destroy(); }
          if (POut != null) { POut.$destroy(); }
          if (Out != null) { Out.$destroy(); }
        }
      }
    }
    {
      /*const*/ CapturedDecl /*P*/ CD = dyn_cast_CapturedDecl(CurrentDecl);
      if ((CD != null)) {
        for (/*const*/ DeclContext /*P*/ DC = CD.getParent$Const(); (DC != null); DC = DC.getParent$Const())  {
          // Skip to its enclosing function or method, but not its enclosing
          // CapturedDecl.
          if (DC.isFunctionOrMethod() && (DC.getDeclKind() != Decl.Kind.Captured)) {
            /*const*/ Decl /*P*/ D = Decl.castFromDeclContext(DC);
            return ComputeName(IT, D);
          }
        }
        throw new llvm_unreachable("CapturedDecl not inside a function or method");
      }
    }
    {
      /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(CurrentDecl);
      if ((MD != null)) {
        raw_svector_ostream Out = null;
        try {
          SmallString/*256*/ Name/*J*/= new SmallString/*256*/(256);
          Out/*J*/= new raw_svector_ostream(Name);
          Out.$out_char((MD.isInstanceMethod() ? $$MINUS : $$PLUS));
          Out.$out_char($$LSQUARE);
          {
            
            // For incorrect code, there might not be an ObjCInterfaceDecl.  Do
            // a null check to avoid a crash.
            /*const*/ ObjCInterfaceDecl /*P*/ ID = MD.getClassInterface$Const();
            if ((ID != null)) {
              $out_raw_ostream_NamedDecl$C(Out, $Deref(ID));
            }
          }
          {
            
            /*const*/ ObjCCategoryImplDecl /*P*/ CID = dyn_cast_ObjCCategoryImplDecl(MD.getDeclContext$Const());
            if ((CID != null)) {
              $out_raw_ostream_ObjCCategoryImplDecl$C(Out.$out_char($$LPAREN), $Deref(CID)).$out_char($$RPAREN);
            }
          }
          
          Out.$out_char($$SPACE);
          MD.getSelector().print(Out);
          Out.$out_char($$RSQUARE);
          
          return Name.str().str();
        } finally {
          if (Out != null) { Out.$destroy(); }
        }
      }
    }
    if (isa_TranslationUnitDecl(CurrentDecl) && IT == IdentType.PrettyFunction) {
      // __PRETTY_FUNCTION__ -> "top level", the others produce an empty string.
      return new std.string(/*KEEP_STR*/"top level");
    }
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1200,
   FQN="clang::PredefinedExpr::getLocStart", NM="_ZNK5clang14PredefinedExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14PredefinedExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1201,
   FQN="clang::PredefinedExpr::getLocEnd", NM="_ZNK5clang14PredefinedExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14PredefinedExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1203,
   FQN="clang::PredefinedExpr::classof", NM="_ZN5clang14PredefinedExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.PredefinedExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::PredefinedExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1208,
   FQN="clang::PredefinedExpr::children", NM="_ZN5clang14PredefinedExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14PredefinedExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(FnName))), new StmtIterator(create_type$ptr($AddrOf(FnName)).$add(1)));
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + ", Type=" + Type // NOI18N
              + ", FnName=" + FnName // NOI18N
              + super.toString(); // NOI18N
  }
}
