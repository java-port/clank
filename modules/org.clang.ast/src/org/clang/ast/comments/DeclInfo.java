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

package org.clang.ast.comments;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// Information about the declaration, useful to clients of FullComment.
//<editor-fold defaultstate="collapsed" desc="clang::comments::DeclInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 986,
 FQN="clang::comments::DeclInfo", NM="_ZN5clang8comments8DeclInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments8DeclInfoE")
//</editor-fold>
public class/*struct*/ DeclInfo {
  /// Declaration the comment is actually attached to (in the source).
  /// Should not be NULL.
  public /*const*/ Decl /*P*/ CommentDecl;
  
  /// CurrentDecl is the declaration with which the FullComment is associated.
  ///
  /// It can be different from \c CommentDecl.  It happens when we we decide
  /// that the comment originally attached to \c CommentDecl is fine for
  /// \c CurrentDecl too (for example, for a redeclaration or an overrider of
  /// \c CommentDecl).
  ///
  /// The information in the DeclInfo corresponds to CurrentDecl.
  public /*const*/ Decl /*P*/ CurrentDecl;
  
  /// Parameters that can be referenced by \\param if \c CommentDecl is something
  /// that we consider a "function".
  public ArrayRef</*const*/ ParmVarDecl /*P*/ > ParamVars;
  
  /// Function return type if \c CommentDecl is something that we consider
  /// a "function".
  public QualType ReturnType;
  
  /// Template parameters that can be referenced by \\tparam if \c CommentDecl is
  /// a template (\c IsTemplateDecl or \c IsTemplatePartialSpecialization is
  /// true).
  public /*const*/ TemplateParameterList /*P*/ TemplateParameters;
  
  /// A simplified description of \c CommentDecl kind that should be good enough
  /// for documentation rendering purposes.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::DeclInfo::DeclKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1016,
   FQN="clang::comments::DeclInfo::DeclKind", NM="_ZN5clang8comments8DeclInfo8DeclKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments8DeclInfo8DeclKindE")
  //</editor-fold>
  public enum DeclKind implements Native.ComparableLower {
    /// Everything else not explicitly mentioned below.
    OtherKind(0),
    
    /// Something that we consider a "function":
    /// \li function,
    /// \li function template,
    /// \li function template specialization,
    /// \li member function,
    /// \li member function template,
    /// \li member function template specialization,
    /// \li ObjC method,
    /// \li a typedef for a function pointer, member function pointer,
    ///     ObjC block.
    FunctionKind(OtherKind.getValue() + 1),
    
    /// Something that we consider a "class":
    /// \li class/struct,
    /// \li class template,
    /// \li class template (partial) specialization.
    ClassKind(FunctionKind.getValue() + 1),
    
    /// Something that we consider a "variable":
    /// \li namespace scope variables;
    /// \li static and non-static class data members;
    /// \li enumerators.
    VariableKind(ClassKind.getValue() + 1),
    
    /// A C++ namespace.
    NamespaceKind(VariableKind.getValue() + 1),
    
    /// A C++ typedef-name (a 'typedef' decl specifier or alias-declaration),
    /// see \c TypedefNameDecl.
    TypedefKind(NamespaceKind.getValue() + 1),
    
    /// An enumeration or scoped enumeration.
    EnumKind(TypedefKind.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DeclKind valueOf(int val) {
      DeclKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DeclKind[] VALUES;
      private static final DeclKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DeclKind kind : DeclKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DeclKind[min < 0 ? (1-min) : 0];
        VALUES = new DeclKind[max >= 0 ? (1+max) : 0];
        for (DeclKind kind : DeclKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private DeclKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DeclKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DeclKind)obj).value);}
    //</editor-fold>
  };
  
  /// What kind of template specialization \c CommentDecl is.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::DeclInfo::TemplateDeclKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1056,
   FQN="clang::comments::DeclInfo::TemplateDeclKind", NM="_ZN5clang8comments8DeclInfo16TemplateDeclKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments8DeclInfo16TemplateDeclKindE")
  //</editor-fold>
  public enum TemplateDeclKind implements Native.ComparableLower {
    NotTemplate(0),
    Template(NotTemplate.getValue() + 1),
    TemplateSpecialization(Template.getValue() + 1),
    TemplatePartialSpecialization(TemplateSpecialization.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TemplateDeclKind valueOf(int val) {
      TemplateDeclKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TemplateDeclKind[] VALUES;
      private static final TemplateDeclKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TemplateDeclKind kind : TemplateDeclKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TemplateDeclKind[min < 0 ? (1-min) : 0];
        VALUES = new TemplateDeclKind[max >= 0 ? (1+max) : 0];
        for (TemplateDeclKind kind : TemplateDeclKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TemplateDeclKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TemplateDeclKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TemplateDeclKind)obj).value);}
    //</editor-fold>
  };
  
  /// If false, only \c CommentDecl is valid.
  public /*JBIT unsigned int*/ boolean IsFilled /*: 1*/;
  
  /// Simplified kind of \c CommentDecl, see \c DeclKind enum.
  public /*JBYTE unsigned int*/ byte Kind /*: 3*/;
  
  /// Is \c CommentDecl a template declaration.
  public /*JBYTE unsigned int*/ byte TemplateKind /*: 2*/;
  
  /// Is \c CommentDecl an ObjCMethodDecl.
  public /*JBIT unsigned int*/ boolean IsObjCMethod /*: 1*/;
  
  /// Is \c CommentDecl a non-static member function of C++ class or
  /// instance method of ObjC class.
  /// Can be true only if \c IsFunctionDecl is true.
  public /*JBIT unsigned int*/ boolean IsInstanceMethod /*: 1*/;
  
  /// Is \c CommentDecl a static member function of C++ class or
  /// class method of ObjC class.
  /// Can be true only if \c IsFunctionDecl is true.
  public /*JBIT unsigned int*/ boolean IsClassMethod /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::DeclInfo::fill">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 129,
   FQN="clang::comments::DeclInfo::fill", NM="_ZN5clang8comments8DeclInfo4fillEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments8DeclInfo4fillEv")
  //</editor-fold>
  public void fill() {
    assert (!IsFilled);
    
    // Set defaults.
    Kind = $uint2uint_3bits(DeclKind.OtherKind.getValue());
    TemplateKind = $uint2uint_2bits(TemplateDeclKind.NotTemplate.getValue());
    IsObjCMethod = false;
    IsInstanceMethod = false;
    IsClassMethod = false;
    ParamVars.$assignMove(new ArrayRef</*const*/ ParmVarDecl /*P*/ >(None, true));
    TemplateParameters = null;
    if (!(CommentDecl != null)) {
      // If there is no declaration, the defaults is our only guess.
      IsFilled = true;
      return;
    }
    CurrentDecl = CommentDecl;
    
    Decl.Kind K = CommentDecl.getKind();
    switch (K) {
     default:
      // Defaults are should be good for declarations we don't handle explicitly.
      break;
     case Function:
     case CXXMethod:
     case CXXConstructor:
     case CXXDestructor:
     case CXXConversion:
      {
        /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(CommentDecl);
        Kind = $uint2uint_3bits(DeclKind.FunctionKind.getValue());
        ParamVars.$assignMove(new ArrayRef</*const*/ ParmVarDecl /*P*/ >(JD$Convertible.INSTANCE, FD.parameters$Const(), true));
        ReturnType.$assignMove(FD.getReturnType());
        /*uint*/int NumLists = FD.getNumTemplateParameterLists();
        if (NumLists != 0) {
          TemplateKind = $uint2uint_2bits(TemplateDeclKind.TemplateSpecialization.getValue());
          TemplateParameters
             = FD.getTemplateParameterList(NumLists - 1);
        }
        if (K == Decl.Kind.CXXMethod || K == Decl.Kind.CXXConstructor
           || K == Decl.Kind.CXXDestructor || K == Decl.Kind.CXXConversion) {
          /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(CommentDecl);
          IsInstanceMethod = MD.isInstance();
          IsClassMethod = !IsInstanceMethod;
        }
        break;
      }
     case ObjCMethod:
      {
        /*const*/ ObjCMethodDecl /*P*/ MD = cast_ObjCMethodDecl(CommentDecl);
        Kind = $uint2uint_3bits(DeclKind.FunctionKind.getValue());
        ParamVars.$assignMove(new ArrayRef</*const*/ ParmVarDecl /*P*/ >(JD$Convertible.INSTANCE, MD.parameters(), true));
        ReturnType.$assignMove(MD.getReturnType());
        IsObjCMethod = true;
        IsInstanceMethod = MD.isInstanceMethod();
        IsClassMethod = !IsInstanceMethod;
        break;
      }
     case FunctionTemplate:
      {
        /*const*/ FunctionTemplateDecl /*P*/ FTD = cast_FunctionTemplateDecl(CommentDecl);
        Kind = $uint2uint_3bits(DeclKind.FunctionKind.getValue());
        TemplateKind = $uint2uint_2bits(TemplateDeclKind.Template.getValue());
        /*const*/ FunctionDecl /*P*/ FD = FTD.getTemplatedDecl();
        ParamVars.$assignMove(new ArrayRef</*const*/ ParmVarDecl /*P*/ >(JD$Convertible.INSTANCE, FD.parameters$Const(), true));
        ReturnType.$assignMove(FD.getReturnType());
        TemplateParameters = FTD.getTemplateParameters();
        break;
      }
     case ClassTemplate:
      {
        /*const*/ ClassTemplateDecl /*P*/ CTD = cast_ClassTemplateDecl(CommentDecl);
        Kind = $uint2uint_3bits(DeclKind.ClassKind.getValue());
        TemplateKind = $uint2uint_2bits(TemplateDeclKind.Template.getValue());
        TemplateParameters = CTD.getTemplateParameters();
        break;
      }
     case ClassTemplatePartialSpecialization:
      {
        /*const*/ ClassTemplatePartialSpecializationDecl /*P*/ CTPSD = cast_ClassTemplatePartialSpecializationDecl(CommentDecl);
        Kind = $uint2uint_3bits(DeclKind.ClassKind.getValue());
        TemplateKind = $uint2uint_2bits(TemplateDeclKind.TemplatePartialSpecialization.getValue());
        TemplateParameters = CTPSD.getTemplateParameters();
        break;
      }
     case ClassTemplateSpecialization:
      Kind = $uint2uint_3bits(DeclKind.ClassKind.getValue());
      TemplateKind = $uint2uint_2bits(TemplateDeclKind.TemplateSpecialization.getValue());
      break;
     case Record:
     case CXXRecord:
      Kind = $uint2uint_3bits(DeclKind.ClassKind.getValue());
      break;
     case Var:
     case Field:
     case EnumConstant:
     case ObjCIvar:
     case ObjCAtDefsField:
      Kind = $uint2uint_3bits(DeclKind.VariableKind.getValue());
      break;
     case Namespace:
      Kind = $uint2uint_3bits(DeclKind.NamespaceKind.getValue());
      break;
     case Typedef:
      {
        Kind = $uint2uint_3bits(DeclKind.TypedefKind.getValue());
        // If this is a typedef to something we consider a function, extract
        // arguments and return type.
        /*const*/ TypedefDecl /*P*/ TD = cast_TypedefDecl(CommentDecl);
        /*const*/ TypeSourceInfo /*P*/ TSI = TD.getTypeSourceInfo();
        if (!(TSI != null)) {
          break;
        }
        TypeLoc TL = new TypeLoc(JD$Move.INSTANCE, TSI.getTypeLoc().getUnqualifiedLoc());
        while (true) {
          TL.$assignMove(TL.IgnoreParens());
          {
            // Look through qualified types.
            QualifiedTypeLoc QualifiedTL = TL.getAs(QualifiedTypeLoc.class);
            if (QualifiedTL.$bool()) {
              TL.$assignMove(QualifiedTL.getUnqualifiedLoc());
              continue;
            }
          }
          {
            // Look through pointer types.
            PointerTypeLoc PointerTL = TL.getAs(PointerTypeLoc.class);
            if (PointerTL.$bool()) {
              TL.$assignMove(PointerTL.getPointeeLoc().getUnqualifiedLoc());
              continue;
            }
          }
          {
            // Look through reference types.
            ReferenceTypeLoc ReferenceTL = TL.getAs(ReferenceTypeLoc.class);
            if (ReferenceTL.$bool()) {
              TL.$assignMove(ReferenceTL.getPointeeLoc().getUnqualifiedLoc());
              continue;
            }
          }
          {
            // Look through adjusted types.
            AdjustedTypeLoc ATL = TL.getAs(AdjustedTypeLoc.class);
            if (ATL.$bool()) {
              TL.$assignMove(ATL.getOriginalLoc());
              continue;
            }
          }
          {
            BlockPointerTypeLoc BlockPointerTL = TL.getAs(BlockPointerTypeLoc.class);
            if (BlockPointerTL.$bool()) {
              TL.$assignMove(BlockPointerTL.getPointeeLoc().getUnqualifiedLoc());
              continue;
            }
          }
          {
            MemberPointerTypeLoc MemberPointerTL = TL.getAs(MemberPointerTypeLoc.class);
            if (MemberPointerTL.$bool()) {
              TL.$assignMove(MemberPointerTL.getPointeeLoc().getUnqualifiedLoc());
              continue;
            }
          }
          {
            ElaboratedTypeLoc ETL = TL.getAs(ElaboratedTypeLoc.class);
            if (ETL.$bool()) {
              TL.$assignMove(ETL.getNamedTypeLoc());
              continue;
            }
          }
          {
            // Is this a typedef for a function type?
            FunctionTypeLoc FTL = TL.getAs(FunctionTypeLoc.class);
            if (FTL.$bool()) {
              Kind = $uint2uint_3bits(DeclKind.FunctionKind.getValue());
              ParamVars.$assignMove(new ArrayRef</*const*/ ParmVarDecl /*P*/ >(JD$Convertible.INSTANCE, FTL.getParams(), true));
              ReturnType.$assignMove(FTL.getReturnLoc().getType());
              break;
            }
          }
          {
            TemplateSpecializationTypeLoc STL = TL.getAs(TemplateSpecializationTypeLoc.class);
            if (STL.$bool()) {
              // If we have a typedef to a template specialization with exactly one
              // template argument of a function type, this looks like std::function,
              // boost::function, or other function wrapper.  Treat these typedefs as
              // functions.
              if (STL.getNumArgs() != 1) {
                break;
              }
              TemplateArgumentLoc MaybeFunction = STL.getArgLoc(0);
              if (MaybeFunction.getArgument().getKind() != TemplateArgument.ArgKind.Type) {
                break;
              }
              TypeSourceInfo /*P*/ MaybeFunctionTSI = MaybeFunction.getTypeSourceInfo();
              TypeLoc _TL = new TypeLoc(JD$Move.INSTANCE, MaybeFunctionTSI.getTypeLoc().getUnqualifiedLoc());
              {
                FunctionTypeLoc FTL = _TL.getAs(FunctionTypeLoc.class);
                if (FTL.$bool()) {
                  Kind = $uint2uint_3bits(DeclKind.FunctionKind.getValue());
                  ParamVars.$assignMove(new ArrayRef</*const*/ ParmVarDecl /*P*/ >(JD$Convertible.INSTANCE, FTL.getParams(), true));
                  ReturnType.$assignMove(FTL.getReturnLoc().getType());
                }
              }
              break;
            }
          }
          break;
        }
        break;
      }
     case TypeAlias:
      Kind = $uint2uint_3bits(DeclKind.TypedefKind.getValue());
      break;
     case TypeAliasTemplate:
      {
        /*const*/ TypeAliasTemplateDecl /*P*/ TAT = cast_TypeAliasTemplateDecl(CommentDecl);
        Kind = $uint2uint_3bits(DeclKind.TypedefKind.getValue());
        TemplateKind = $uint2uint_2bits(TemplateDeclKind.Template.getValue());
        TemplateParameters = TAT.getTemplateParameters();
        break;
      }
     case Enum:
      Kind = $uint2uint_3bits(DeclKind.EnumKind.getValue());
      break;
    }
    
    IsFilled = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::DeclInfo::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1087,
   FQN="clang::comments::DeclInfo::getKind", NM="_ZNK5clang8comments8DeclInfo7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments8DeclInfo7getKindEv")
  //</editor-fold>
  public DeclKind getKind() /*const*//* __attribute__((pure))*/ {
    return /*static_cast*/DeclKind.valueOf(Kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::DeclInfo::getTemplateKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1091,
   FQN="clang::comments::DeclInfo::getTemplateKind", NM="_ZNK5clang8comments8DeclInfo15getTemplateKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments8DeclInfo15getTemplateKindEv")
  //</editor-fold>
  public TemplateDeclKind getTemplateKind() /*const*//* __attribute__((pure))*/ {
    return /*static_cast*/TemplateDeclKind.valueOf(TemplateKind);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::DeclInfo::DeclInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 986,
   FQN="clang::comments::DeclInfo::DeclInfo", NM="_ZN5clang8comments8DeclInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments8DeclInfoC1Ev")
  //</editor-fold>
  public /*inline*/ DeclInfo() {
    // : ParamVars(), ReturnType() 
    //START JInit
    this.ParamVars = new ArrayRef</*const*/ ParmVarDecl /*P*/ >(true);
    this.ReturnType = new QualType();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "CommentDecl=" + CommentDecl // NOI18N
              + ", CurrentDecl=" + CurrentDecl // NOI18N
              + ", ParamVars=" + ParamVars // NOI18N
              + ", ReturnType=" + ReturnType // NOI18N
              + ", TemplateParameters=" + TemplateParameters // NOI18N
              + ", IsFilled=" + IsFilled // NOI18N
              + ", Kind=" + $uchar2uint(Kind) // NOI18N
              + ", TemplateKind=" + $uchar2uint(TemplateKind) // NOI18N
              + ", IsObjCMethod=" + IsObjCMethod // NOI18N
              + ", IsInstanceMethod=" + IsInstanceMethod // NOI18N
              + ", IsClassMethod=" + IsClassMethod; // NOI18N
  }
}
