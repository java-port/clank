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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.QualType.StreamedQualTypeHelper.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;
import org.clang.ast.java.ParamType;
import static org.clang.basic.BasicClangGlobals.*;


/// Represents a prototype with parameter type info, e.g.
/// 'int foo(int)' or 'int foo(void)'.  'void' is represented as having no
/// parameters, not as having a single void parameter. Such a type can have an
/// exception specification, but this specification is not part of the canonical
/// type.
//<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3073,
 FQN="clang::FunctionProtoType", NM="_ZN5clang17FunctionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoTypeE")
//</editor-fold>
public class FunctionProtoType extends /*public*/ FunctionType implements /*public*/ FoldingSetImpl.ContextualNode<ASTContext>, ParamType {
/*public:*/
  /// Interesting information about a specific parameter that can't simply
  /// be reflected in parameter's type.
  ///
  /// It makes sense to model language features this way when there's some
  /// sort of parameter-specific override (such as an attribute) that
  /// affects how the function is called.  For example, the ARC ns_consumed
  /// attribute changes whether a parameter is passed at +0 (the default)
  /// or +1 (ns_consumed).  This must be reflected in the function type,
  /// but isn't really a change to the parameter type.
  ///
  /// One serious disadvantage of modelling language features this way is
  /// that they generally do not work with language features that attempt
  /// to destructure types.  For example, template argument deduction will
  /// not be able to match a parameter declared as
  ///   T (*)(U)
  /// against an argument of type
  ///   void (*)(__attribute__((ns_consumed)) id)
  /// because the substitution of T=void, U=id into the former will
  /// not produce the latter.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3094,
   FQN="clang::FunctionProtoType::ExtParameterInfo", NM="_ZN5clang17FunctionProtoType16ExtParameterInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType16ExtParameterInfoE")
  //</editor-fold>
  public static class ExtParameterInfo implements NativePOD<ExtParameterInfo> {
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3095,
     FQN="clang::FunctionProtoType::ExtParameterInfo::(anonymous)", NM="_ZN5clang17FunctionProtoType16ExtParameterInfoE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType16ExtParameterInfoE_Unnamed_enum")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int ABIMask = 0x0F;
      public static final /*uint*/int IsConsumed = 0x10;
    /*}*/;
    private /*uchar*/byte Data;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::ExtParameterInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3101,
     FQN="clang::FunctionProtoType::ExtParameterInfo::ExtParameterInfo", NM="_ZN5clang17FunctionProtoType16ExtParameterInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType16ExtParameterInfoC1Ev")
    //</editor-fold>
    public ExtParameterInfo() {
      // : Data(0) 
      //START JInit
      this.Data = 0;
      //END JInit
    }

    
    /// Return the ABI treatment of this parameter.
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::getABI">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3104,
     FQN="clang::FunctionProtoType::ExtParameterInfo::getABI", NM="_ZNK5clang17FunctionProtoType16ExtParameterInfo6getABIEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType16ExtParameterInfo6getABIEv")
    //</editor-fold>
    public ParameterABI getABI() /*const*/ {
      return ParameterABI.valueOf($uchar2int(Data) & ABIMask);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::withABI">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3107,
     FQN="clang::FunctionProtoType::ExtParameterInfo::withABI", NM="_ZNK5clang17FunctionProtoType16ExtParameterInfo7withABIENS_12ParameterABIE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType16ExtParameterInfo7withABIENS_12ParameterABIE")
    //</editor-fold>
    public ExtParameterInfo withABI(ParameterABI kind) /*const*/ {
      ExtParameterInfo copy = new ExtParameterInfo(/*Deref*/this);
      copy.Data = $uint2uchar(($uchar2int(copy.Data) & ~ABIMask) | kind.getValue());
      return copy;
    }

    
    /// Is this parameter considered "consumed" by Objective-C ARC?
    /// Consumed parameters must have retainable object type.
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::isConsumed">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3115,
     FQN="clang::FunctionProtoType::ExtParameterInfo::isConsumed", NM="_ZNK5clang17FunctionProtoType16ExtParameterInfo10isConsumedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType16ExtParameterInfo10isConsumedEv")
    //</editor-fold>
    public boolean isConsumed() /*const*/ {
      return (($uchar2int(Data) & IsConsumed) != 0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::withIsConsumed">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3118,
     FQN="clang::FunctionProtoType::ExtParameterInfo::withIsConsumed", NM="_ZNK5clang17FunctionProtoType16ExtParameterInfo14withIsConsumedEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType16ExtParameterInfo14withIsConsumedEb")
    //</editor-fold>
    public ExtParameterInfo withIsConsumed(boolean consumed) /*const*/ {
      ExtParameterInfo copy = new ExtParameterInfo(/*Deref*/this);
      if (consumed) {
        copy.Data |= IsConsumed;
      } else {
        copy.Data &= ~IsConsumed;
      }
      return copy;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::getOpaqueValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3128,
     FQN="clang::FunctionProtoType::ExtParameterInfo::getOpaqueValue", NM="_ZNK5clang17FunctionProtoType16ExtParameterInfo14getOpaqueValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType16ExtParameterInfo14getOpaqueValueEv")
    //</editor-fold>
    public /*uchar*/byte getOpaqueValue() /*const*/ {
      return Data;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::getFromOpaqueValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3129,
     FQN="clang::FunctionProtoType::ExtParameterInfo::getFromOpaqueValue", NM="_ZN5clang17FunctionProtoType16ExtParameterInfo18getFromOpaqueValueEh",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType16ExtParameterInfo18getFromOpaqueValueEh")
    //</editor-fold>
    public static ExtParameterInfo getFromOpaqueValue(/*uchar*/byte data) {
      ExtParameterInfo result/*J*/= new ExtParameterInfo();
      result.Data = data;
      return result;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3135,
     FQN="clang::operator==", NM="_ZN5clangeqENS_17FunctionProtoType16ExtParameterInfoES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clangeqENS_17FunctionProtoType16ExtParameterInfoES1_")
    //</editor-fold>
    public static boolean $eq_ExtParameterInfo(ExtParameterInfo lhs, ExtParameterInfo rhs) {
      return $uchar2int(lhs.Data) == $uchar2int(rhs.Data);
    }

    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3138,
     FQN="clang::operator!=", NM="_ZN5clangneENS_17FunctionProtoType16ExtParameterInfoES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clangneENS_17FunctionProtoType16ExtParameterInfoES1_")
    //</editor-fold>
    public static boolean $noteq_ExtParameterInfo(ExtParameterInfo lhs, ExtParameterInfo rhs) {
      return $uchar2int(lhs.Data) != $uchar2int(rhs.Data);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::ExtParameterInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3094,
     FQN="clang::FunctionProtoType::ExtParameterInfo::ExtParameterInfo", NM="_ZN5clang17FunctionProtoType16ExtParameterInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType16ExtParameterInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ExtParameterInfo(final /*const*/ ExtParameterInfo /*&*/ $Prm0) {
      // : Data(.Data) 
      //START JInit
      this.Data = $Prm0.Data;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::ExtParameterInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3094,
     FQN="clang::FunctionProtoType::ExtParameterInfo::ExtParameterInfo", NM="_ZN5clang17FunctionProtoType16ExtParameterInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType16ExtParameterInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ ExtParameterInfo(JD$Move _dparam, final ExtParameterInfo /*&&*/$Prm0) {
      // : Data(static_cast<ExtParameterInfo &&>().Data) 
      //START JInit
      this.Data = $Prm0.Data;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3094,
     FQN="clang::FunctionProtoType::ExtParameterInfo::operator=", NM="_ZN5clang17FunctionProtoType16ExtParameterInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang17FunctionProtoType16ExtParameterInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ ExtParameterInfo /*&*/ $assign(final /*const*/ ExtParameterInfo /*&*/ $Prm0) {
      this.Data = $Prm0.Data;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtParameterInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3094,
     FQN="clang::FunctionProtoType::ExtParameterInfo::operator=", NM="_ZN5clang17FunctionProtoType16ExtParameterInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang17FunctionProtoType16ExtParameterInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ ExtParameterInfo /*&*/ $assignMove(final ExtParameterInfo /*&&*/$Prm0) {
      this.Data = $Prm0.Data;
      return /*Deref*/this;
    }

    @Override public ExtParameterInfo clone() { return new ExtParameterInfo(this); }
    
    @Override public String toString() {
      return "" + "Data=" + $uchar2uint(Data); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExceptionSpecInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3143,
   FQN="clang::FunctionProtoType::ExceptionSpecInfo", NM="_ZN5clang17FunctionProtoType17ExceptionSpecInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType17ExceptionSpecInfoE")
  //</editor-fold>
  public static class/*struct*/ ExceptionSpecInfo {
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExceptionSpecInfo::ExceptionSpecInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3144,
     FQN="clang::FunctionProtoType::ExceptionSpecInfo::ExceptionSpecInfo", NM="_ZN5clang17FunctionProtoType17ExceptionSpecInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType17ExceptionSpecInfoC1Ev")
    //</editor-fold>
    public ExceptionSpecInfo() {
      // : Type(EST_None), Exceptions(), NoexceptExpr(null), SourceDecl(null), SourceTemplate(null) 
      //START JInit
      this.Type = ExceptionSpecificationType.EST_None;
      this.Exceptions = new ArrayRef<QualType>(false);
      this.NoexceptExpr = null;
      this.SourceDecl = null;
      this.SourceTemplate = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExceptionSpecInfo::ExceptionSpecInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3148,
     FQN="clang::FunctionProtoType::ExceptionSpecInfo::ExceptionSpecInfo", NM="_ZN5clang17FunctionProtoType17ExceptionSpecInfoC1ENS_26ExceptionSpecificationTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType17ExceptionSpecInfoC1ENS_26ExceptionSpecificationTypeE")
    //</editor-fold>
    public ExceptionSpecInfo(ExceptionSpecificationType EST) {
      // : Type(EST), Exceptions(), NoexceptExpr(null), SourceDecl(null), SourceTemplate(null) 
      //START JInit
      this.Type = EST;
      this.Exceptions = new ArrayRef<QualType>(false);
      this.NoexceptExpr = null;
      this.SourceDecl = null;
      this.SourceTemplate = null;
      //END JInit
    }

    
    /// The kind of exception specification this is.
    public ExceptionSpecificationType Type;
    /// Explicitly-specified list of exception types.
    public ArrayRef<QualType> Exceptions;
    /// Noexcept expression, if this is EST_ComputedNoexcept.
    public Expr /*P*/ NoexceptExpr;
    /// The function whose exception specification this is, for
    /// EST_Unevaluated and EST_Uninstantiated.
    public FunctionDecl /*P*/ SourceDecl;
    /// The function template whose exception specification this is instantiated
    /// from, for EST_Uninstantiated.
    public FunctionDecl /*P*/ SourceTemplate;
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExceptionSpecInfo::ExceptionSpecInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3143,
     FQN="clang::FunctionProtoType::ExceptionSpecInfo::ExceptionSpecInfo", NM="_ZN5clang17FunctionProtoType17ExceptionSpecInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType17ExceptionSpecInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ExceptionSpecInfo(final /*const*/ ExceptionSpecInfo /*&*/ $Prm0) {
      // : Type(.Type), Exceptions(.Exceptions), NoexceptExpr(.NoexceptExpr), SourceDecl(.SourceDecl), SourceTemplate(.SourceTemplate) 
      //START JInit
      this.Type = $Prm0.Type;
      this.Exceptions = new ArrayRef<QualType>($Prm0.Exceptions);
      this.NoexceptExpr = $Prm0.NoexceptExpr;
      this.SourceDecl = $Prm0.SourceDecl;
      this.SourceTemplate = $Prm0.SourceTemplate;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExceptionSpecInfo::ExceptionSpecInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3143,
     FQN="clang::FunctionProtoType::ExceptionSpecInfo::ExceptionSpecInfo", NM="_ZN5clang17FunctionProtoType17ExceptionSpecInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType17ExceptionSpecInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ ExceptionSpecInfo(JD$Move _dparam, final ExceptionSpecInfo /*&&*/$Prm0) {
      // : Type(static_cast<ExceptionSpecInfo &&>().Type), Exceptions(static_cast<ExceptionSpecInfo &&>().Exceptions), NoexceptExpr(static_cast<ExceptionSpecInfo &&>().NoexceptExpr), SourceDecl(static_cast<ExceptionSpecInfo &&>().SourceDecl), SourceTemplate(static_cast<ExceptionSpecInfo &&>().SourceTemplate) 
      //START JInit
      this.Type = $Prm0.Type;
      this.Exceptions = new ArrayRef<QualType>(JD$Move.INSTANCE, $Prm0.Exceptions);
      this.NoexceptExpr = $Prm0.NoexceptExpr;
      this.SourceDecl = $Prm0.SourceDecl;
      this.SourceTemplate = $Prm0.SourceTemplate;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExceptionSpecInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3143,
     FQN="clang::FunctionProtoType::ExceptionSpecInfo::operator=", NM="_ZN5clang17FunctionProtoType17ExceptionSpecInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType17ExceptionSpecInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ ExceptionSpecInfo /*&*/ $assign(final /*const*/ ExceptionSpecInfo /*&*/ $Prm0) {
      this.Type = $Prm0.Type;
      this.Exceptions.$assign($Prm0.Exceptions);
      this.NoexceptExpr = $Prm0.NoexceptExpr;
      this.SourceDecl = $Prm0.SourceDecl;
      this.SourceTemplate = $Prm0.SourceTemplate;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExceptionSpecInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3143,
     FQN="clang::FunctionProtoType::ExceptionSpecInfo::operator=", NM="_ZN5clang17FunctionProtoType17ExceptionSpecInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType17ExceptionSpecInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ ExceptionSpecInfo /*&*/ $assignMove(final ExceptionSpecInfo /*&&*/$Prm0) {
      this.Type = $Prm0.Type;
      this.Exceptions.$assignMove($Prm0.Exceptions);
      this.NoexceptExpr = $Prm0.NoexceptExpr;
      this.SourceDecl = $Prm0.SourceDecl;
      this.SourceTemplate = $Prm0.SourceTemplate;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Type=" + Type // NOI18N
                + ", Exceptions=" + Exceptions // NOI18N
                + ", NoexceptExpr=" + NoexceptExpr // NOI18N
                + ", SourceDecl=" + SourceDecl // NOI18N
                + ", SourceTemplate=" + SourceTemplate; // NOI18N
    }
  };
  
  /// Extra information about a function prototype.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtProtoInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3167,
   FQN="clang::FunctionProtoType::ExtProtoInfo", NM="_ZN5clang17FunctionProtoType12ExtProtoInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType12ExtProtoInfoE")
  //</editor-fold>
  public static class/*struct*/ ExtProtoInfo {
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtProtoInfo::ExtProtoInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3168,
     FQN="clang::FunctionProtoType::ExtProtoInfo::ExtProtoInfo", NM="_ZN5clang17FunctionProtoType12ExtProtoInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType12ExtProtoInfoC1Ev")
    //</editor-fold>
    public ExtProtoInfo() {
      // : ExtInfo(), Variadic(false), HasTrailingReturn(false), TypeQuals(0), RefQualifier(RQ_None), ExceptionSpec(), ExtParameterInfos(null) 
      //START JInit
      this.ExtInfo = new FunctionType.ExtInfo();
      this.Variadic = false;
      this.HasTrailingReturn = false;
      this.TypeQuals = 0;
      this.RefQualifier = RefQualifierKind.RQ_None;
      this.ExceptionSpec = new ExceptionSpecInfo();
      this.ExtParameterInfos = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtProtoInfo::ExtProtoInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3172,
     FQN="clang::FunctionProtoType::ExtProtoInfo::ExtProtoInfo", NM="_ZN5clang17FunctionProtoType12ExtProtoInfoC1ENS_11CallingConvE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType12ExtProtoInfoC1ENS_11CallingConvE")
    //</editor-fold>
    public ExtProtoInfo(CallingConv CC) {
      // : ExtInfo(CC), Variadic(false), HasTrailingReturn(false), TypeQuals(0), RefQualifier(RQ_None), ExceptionSpec(), ExtParameterInfos(null) 
      //START JInit
      this.ExtInfo = new FunctionType.ExtInfo(CC);
      this.Variadic = false;
      this.HasTrailingReturn = false;
      this.TypeQuals = 0;
      this.RefQualifier = RefQualifierKind.RQ_None;
      this.ExceptionSpec = new ExceptionSpecInfo();
      this.ExtParameterInfos = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtProtoInfo::withExceptionSpec">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3176,
     FQN="clang::FunctionProtoType::ExtProtoInfo::withExceptionSpec", NM="_ZN5clang17FunctionProtoType12ExtProtoInfo17withExceptionSpecERKNS0_17ExceptionSpecInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType12ExtProtoInfo17withExceptionSpecERKNS0_17ExceptionSpecInfoE")
    //</editor-fold>
    public ExtProtoInfo withExceptionSpec(final /*const*/ ExceptionSpecInfo /*&*/ O) {
      ExtProtoInfo Result/*J*/= new ExtProtoInfo(/*Deref*/this);
      Result.ExceptionSpec.$assign(O);
      return Result;
    }

    
    public FunctionType.ExtInfo ExtInfo;
    public /*JBIT bool*/ boolean Variadic /*: 1*/;
    public /*JBIT bool*/ boolean HasTrailingReturn /*: 1*/;
    public /*uchar*/byte TypeQuals;
    public RefQualifierKind RefQualifier;
    public ExceptionSpecInfo ExceptionSpec;
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
    public /*const*/ type$ptr<ExtParameterInfo /*P*/> ExtParameterInfos;
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtProtoInfo::ExtProtoInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3167,
     FQN="clang::FunctionProtoType::ExtProtoInfo::ExtProtoInfo", NM="_ZN5clang17FunctionProtoType12ExtProtoInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType12ExtProtoInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ExtProtoInfo(final /*const*/ ExtProtoInfo /*&*/ $Prm0) {
      // : ExtInfo(.ExtInfo), Variadic(.Variadic), HasTrailingReturn(.HasTrailingReturn), TypeQuals(.TypeQuals), RefQualifier(.RefQualifier), ExceptionSpec(.ExceptionSpec), ExtParameterInfos(.ExtParameterInfos) 
      //START JInit
      this.ExtInfo = new FunctionType.ExtInfo($Prm0.ExtInfo);
      this.Variadic = $Prm0.Variadic;
      this.HasTrailingReturn = $Prm0.HasTrailingReturn;
      this.TypeQuals = $Prm0.TypeQuals;
      this.RefQualifier = $Prm0.RefQualifier;
      this.ExceptionSpec = new ExceptionSpecInfo($Prm0.ExceptionSpec);
      this.ExtParameterInfos = $Prm0.ExtParameterInfos;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtProtoInfo::ExtProtoInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3167,
     FQN="clang::FunctionProtoType::ExtProtoInfo::ExtProtoInfo", NM="_ZN5clang17FunctionProtoType12ExtProtoInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType12ExtProtoInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ ExtProtoInfo(JD$Move _dparam, final ExtProtoInfo /*&&*/$Prm0) {
      // : ExtInfo(static_cast<ExtProtoInfo &&>().ExtInfo), Variadic(static_cast<ExtProtoInfo &&>().Variadic), HasTrailingReturn(static_cast<ExtProtoInfo &&>().HasTrailingReturn), TypeQuals(static_cast<ExtProtoInfo &&>().TypeQuals), RefQualifier(static_cast<ExtProtoInfo &&>().RefQualifier), ExceptionSpec(static_cast<ExtProtoInfo &&>().ExceptionSpec), ExtParameterInfos(static_cast<ExtProtoInfo &&>().ExtParameterInfos) 
      //START JInit
      this.ExtInfo = new FunctionType.ExtInfo(JD$Move.INSTANCE, $Prm0.ExtInfo);
      this.Variadic = $Prm0.Variadic;
      this.HasTrailingReturn = $Prm0.HasTrailingReturn;
      this.TypeQuals = $Prm0.TypeQuals;
      this.RefQualifier = $Prm0.RefQualifier;
      this.ExceptionSpec = new ExceptionSpecInfo(JD$Move.INSTANCE, $Prm0.ExceptionSpec);
      this.ExtParameterInfos = $Prm0.ExtParameterInfos;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::ExtProtoInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3167,
     FQN="clang::FunctionProtoType::ExtProtoInfo::operator=", NM="_ZN5clang17FunctionProtoType12ExtProtoInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang17FunctionProtoType12ExtProtoInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ ExtProtoInfo /*&*/ $assignMove(final ExtProtoInfo /*&&*/$Prm0) {
      this.ExtInfo.$assignMove($Prm0.ExtInfo);
      this.Variadic = $Prm0.Variadic;
      this.HasTrailingReturn = $Prm0.HasTrailingReturn;
      this.TypeQuals = $Prm0.TypeQuals;
      this.RefQualifier = $Prm0.RefQualifier;
      this.ExceptionSpec.$assignMove($Prm0.ExceptionSpec);
      this.ExtParameterInfos = $Prm0.ExtParameterInfos;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "ExtInfo=" + ExtInfo // NOI18N
                + ", Variadic=" + Variadic // NOI18N
                + ", HasTrailingReturn=" + HasTrailingReturn // NOI18N
                + ", TypeQuals=" + $uchar2uint(TypeQuals) // NOI18N
                + ", RefQualifier=" + RefQualifier // NOI18N
                + ", ExceptionSpec=" + ExceptionSpec // NOI18N
                + ", ExtParameterInfos=" + ExtParameterInfos; // NOI18N
    }
  };
/*private:*/
  /// \brief Determine whether there are any argument types that
  /// contain an unexpanded parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::containsAnyUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3194,
   FQN="clang::FunctionProtoType::containsAnyUnexpandedParameterPack", NM="_ZN5clang17FunctionProtoType34containsAnyUnexpandedParameterPackEPKNS_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType34containsAnyUnexpandedParameterPackEPKNS_8QualTypeEj")
  //</editor-fold>
  private static boolean containsAnyUnexpandedParameterPack(/*const*/type$ptr<QualType /*P*/> ArgArray, 
                                    /*uint*/int numArgs) {
    for (/*uint*/int Idx = 0; $less_uint(Idx, numArgs); ++Idx)  {
      if (ArgArray.$at(Idx).$arrow().containsUnexpandedParameterPack()) {
        return true;
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::FunctionProtoType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*this+1*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2654,
   FQN="clang::FunctionProtoType::FunctionProtoType", NM="_ZN5clang17FunctionProtoTypeC1ENS_8QualTypeEN4llvm8ArrayRefIS1_EES1_RKNS0_12ExtProtoInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17FunctionProtoTypeC1ENS_8QualTypeEN4llvm8ArrayRefIS1_EES1_RKNS0_12ExtProtoInfoE")
  //</editor-fold>
  /*friend*//*package*/ FunctionProtoType(type$ptr<?> This$Plus$1, QualType result, ArrayRef<QualType> params, 
      QualType canonical, 
      final /*const*/ ExtProtoInfo /*&*/ epi) {
    // : FunctionType(FunctionProto, result, canonical, result->isDependentType(), result->isInstantiationDependentType(), result->isVariablyModifiedType(), result->containsUnexpandedParameterPack(), epi.ExtInfo), FoldingSetNode(), NumParams(params.size()), NumExceptions(epi.ExceptionSpec.Exceptions.size()), ExceptionSpecType(epi.ExceptionSpec.Type), HasExtParameterInfos(epi.ExtParameterInfos != null), Variadic(epi.Variadic), HasTrailingReturn(epi.HasTrailingReturn) 
    //START JInit
    super(TypeClass.FunctionProto, new QualType(result), new QualType(canonical), 
        result.$arrow().isDependentType(), 
        result.$arrow().isInstantiationDependentType(), 
        result.$arrow().isVariablyModifiedType(), 
        result.$arrow().containsUnexpandedParameterPack(), new ExtInfo(epi.ExtInfo));
    $Node();
    this.NumParams = $uint2uint_15bits(params.size());
    this.NumExceptions = $uint2uint_9bits(epi.ExceptionSpec.Exceptions.size());
    this.ExceptionSpecType = $uint2uint_4bits(epi.ExceptionSpec.Type.getValue());
    this.HasExtParameterInfos = epi.ExtParameterInfos != null;
    this.Variadic = epi.Variadic;
    this.HasTrailingReturn = epi.HasTrailingReturn;
    //END JInit
    assert (NumParams == $uint2uint_15bits(params.size())) : "function has too many parameters";
    
    Unnamed_field.FunctionTypeBits.TypeQuals = $uint2uint_4bits($uchar2uint(epi.TypeQuals));
    Unnamed_field.FunctionTypeBits.RefQualifier = $uint2uint_2bits(epi.RefQualifier.getValue());

    // Fill in the trailing argument array.
    this$plus$1 = $toConst(This$Plus$1);//((type$ptr<QualType /*P*/> )reinterpret_cast(type$ptr.class, this + 1)));
    type$ptr<QualType /*P*/> argSlot = (type$ptr<QualType /*P*/>) this$plus$1;
    for (/*uint*/int i = 0; i != NumParams; ++i) {
      if (params.$at(i).$arrow().isDependentType()) {
        setDependent();
      } else if (params.$at(i).$arrow().isInstantiationDependentType()) {
        setInstantiationDependent();
      }
      if (params.$at(i).$arrow().containsUnexpandedParameterPack()) {
        setContainsUnexpandedParameterPack();
      }
      
      argSlot.$set(i, params.$at(i));
    }
    if (getExceptionSpecType() == ExceptionSpecificationType.EST_Dynamic) {
      // Fill in the exception array.
      type$ptr<QualType /*P*/> exnSlot = (type$ptr<QualType /*P*/>) this$plus$1.$add(NumParams);
      /*uint*/int I = 0;
      for (QualType ExceptionType : epi.ExceptionSpec.Exceptions) {
        // Note that a dependent exception specification does *not* make
        // a type dependent; it's not even part of the C++ type system.
        if (ExceptionType.$arrow().isInstantiationDependentType()) {
          setInstantiationDependent();
        }
        if (ExceptionType.$arrow().containsUnexpandedParameterPack()) {
          setContainsUnexpandedParameterPack();
        }
        
        exnSlot.$set(I++, ExceptionType);
      }
    } else if (getExceptionSpecType() == ExceptionSpecificationType.EST_ComputedNoexcept) {
      // Store the noexcept expression and context.
      type$ptr<Expr /*P*/ /*P*/> noexSlot = (type$ptr<Expr /*P*/ /*P*/>) this$plus$1.$add(NumParams);//$tryClone(((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, argSlot.$add(NumParams))));
      noexSlot.$set(epi.ExceptionSpec.NoexceptExpr);
      if ((epi.ExceptionSpec.NoexceptExpr != null)) {
        if (epi.ExceptionSpec.NoexceptExpr.isValueDependent()
           || epi.ExceptionSpec.NoexceptExpr.isInstantiationDependent()) {
          setInstantiationDependent();
        }
        if (epi.ExceptionSpec.NoexceptExpr.containsUnexpandedParameterPack()) {
          setContainsUnexpandedParameterPack();
        }
      }
    } else if (getExceptionSpecType() == ExceptionSpecificationType.EST_Uninstantiated) {
      // Store the function decl from which we will resolve our
      // exception specification.
      type$ptr<FunctionDecl /*P*/ /*P*/> slot = (type$ptr<FunctionDecl /*P*/ /*P*/>) this$plus$1.$add(NumParams);//$tryClone(((type$ptr<FunctionDecl /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, argSlot.$add(NumParams))));
      slot.$set(0, epi.ExceptionSpec.SourceDecl);
      slot.$set(1, epi.ExceptionSpec.SourceTemplate);
      // This exception specification doesn't make the type dependent, because
      // it's not instantiated as part of instantiating the type.
    } else if (getExceptionSpecType() == ExceptionSpecificationType.EST_Unevaluated) {
      // Store the function decl from which we will resolve our
      // exception specification.
      type$ptr<FunctionDecl /*P*/ /*P*/> slot = (type$ptr<FunctionDecl /*P*/ /*P*/>) this$plus$1.$add(NumParams);//$tryClone(((type$ptr<FunctionDecl /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, argSlot.$add(NumParams))));
      slot.$set(0, epi.ExceptionSpec.SourceDecl);
    }
    if ((epi.ExtParameterInfos != null)) {
      type$ptr<ExtParameterInfo /*P*/> extParamInfos = ((/*const_cast*/type$ptr<ExtParameterInfo /*P*/> )(getExtParameterInfosBuffer()));
      for (/*uint*/int i = 0; i != NumParams; ++i)  {
        extParamInfos.$set(i, epi.ExtParameterInfos.$at(i));
      }
    }
  }


  
  /// The number of parameters this function has, not counting '...'.
  private /*JCHAR unsigned int*/ char NumParams /*: 15*/;
  
  /// The number of types in the exception spec, if any.
  private /*JCHAR unsigned int*/ char NumExceptions /*: 9*/;
  
  /// The type of exception specification this function has.
  private /*JBYTE unsigned int*/ byte ExceptionSpecType /*: 4*/;
  
  /// Whether this function has extended parameter information.
  private /*JBIT unsigned int*/ boolean HasExtParameterInfos /*: 1*/;
  
  /// Whether the function is variadic.
  private /*JBIT unsigned int*/ boolean Variadic /*: 1*/;
  
  /// Whether this function has a trailing return type.
  private /*JBIT unsigned int*/ boolean HasTrailingReturn /*: 1*/;
  
  // ParamInfo - There is an variable size array after the class in memory that
  // holds the parameter types.
  
  // Exceptions - There is another variable size array after ArgInfo that
  // holds the exception types.
  
  // NoexceptExpr - Instead of Exceptions, there may be a single Expr* pointing
  // to the expression in the noexcept() specifier.
  
  // ExceptionSpecDecl, ExceptionSpecTemplate - Instead of Exceptions, there may
  // be a pair of FunctionDecl* pointing to the function which should be used to
  // instantiate this function type's exception specification, and the function
  // from which it should be instantiated.
  
  // ExtParameterInfos - A variable size array, following the exception
  // specification and of length NumParams, holding an ExtParameterInfo
  // for each of the parameters.  This only appears if HasExtParameterInfos
  // is true.
  /*friend  class ASTContext*/ // ASTContext creates these.
  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExtParameterInfosBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3245,
   FQN="clang::FunctionProtoType::getExtParameterInfosBuffer", NM="_ZNK5clang17FunctionProtoType26getExtParameterInfosBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType26getExtParameterInfosBufferEv")
  //</editor-fold>
  private /*const*/ type$ptr<ExtParameterInfo /*P*/> getExtParameterInfosBuffer() /*const*/ {
    assert (hasExtParameterInfos());
    
    // Find the end of the exception specification.
    type$ptr<?> ptr = exception_begin();///*const*/char$ptr/*char P*/ ptr = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, exception_begin()));
    ptr.$inc(getExceptionSpecSize());
    
    return (type$ptr<ExtParameterInfo /*P*/>)ptr;//reinterpret_cast(/*const*/ ExtParameterInfo /*P*/ .class, ptr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExceptionSpecSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3255,
   FQN="clang::FunctionProtoType::getExceptionSpecSize", NM="_ZNK5clang17FunctionProtoType20getExceptionSpecSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType20getExceptionSpecSizeEv")
  //</editor-fold>
  private /*size_t*/int getExceptionSpecSize() /*const*/ {
    switch (getExceptionSpecType()) {
     case EST_None:
      return 0;
     case EST_DynamicNone:
      return 0;
     case EST_MSAny:
      return 0;
     case EST_BasicNoexcept:
      return 0;
     case EST_Unparsed:
      return 0;
     case EST_Dynamic:
      return getNumExceptions() * (true/*JAVA*/ ? 1 : $sizeof_QualType());
     case EST_ComputedNoexcept:
      return (true/*JAVA*/ ? 1 : $sizeof_ptr(/*Expr  */));
     case EST_Uninstantiated:
      return 2 * (true/*JAVA*/ ? 1 :  $sizeof_ptr(/*FunctionDecl  */));
     case EST_Unevaluated:
      return (true/*JAVA*/ ? 1 : $sizeof_ptr(/*FunctionDecl  */));
    }
    throw new llvm_unreachable("bad exception specification kind");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getNumParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3271,
   FQN="clang::FunctionProtoType::getNumParams", NM="_ZNK5clang17FunctionProtoType12getNumParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType12getNumParamsEv")
  //</editor-fold>
  public /*uint*/int getNumParams() /*const*/ {
    return NumParams;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getParamType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3272,
   FQN="clang::FunctionProtoType::getParamType", NM="_ZNK5clang17FunctionProtoType12getParamTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType12getParamTypeEj")
  //</editor-fold>
  public QualType getParamType(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumParams)) : "invalid parameter index";
    return new QualType(param_type_begin().$at(i));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getParamTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3276,
   FQN="clang::FunctionProtoType::getParamTypes", NM="_ZNK5clang17FunctionProtoType13getParamTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType13getParamTypesEv")
  //</editor-fold>
  public ArrayRef<QualType> getParamTypes() /*const*/ {
    return llvm.makeArrayRef(param_type_begin(), param_type_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExtProtoInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3280,
   FQN="clang::FunctionProtoType::getExtProtoInfo", NM="_ZNK5clang17FunctionProtoType15getExtProtoInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType15getExtProtoInfoEv")
  //</editor-fold>
  public ExtProtoInfo getExtProtoInfo() /*const*/ {
    ExtProtoInfo EPI/*J*/= new ExtProtoInfo();
    EPI.ExtInfo.$assignMove(getExtInfo());
    EPI.Variadic = isVariadic();
    EPI.HasTrailingReturn = hasTrailingReturn();
    EPI.ExceptionSpec.Type = getExceptionSpecType();
    EPI.TypeQuals = ((/*static_cast*//*uchar*/byte)($uint2uchar(getTypeQuals())));
    EPI.RefQualifier = getRefQualifier();
    if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_Dynamic) {
      EPI.ExceptionSpec.Exceptions.$assignMove(exceptions());
    } else if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_ComputedNoexcept) {
      EPI.ExceptionSpec.NoexceptExpr = getNoexceptExpr();
    } else if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_Uninstantiated) {
      EPI.ExceptionSpec.SourceDecl = getExceptionSpecDecl();
      EPI.ExceptionSpec.SourceTemplate = getExceptionSpecTemplate();
    } else if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_Unevaluated) {
      EPI.ExceptionSpec.SourceDecl = getExceptionSpecDecl();
    }
    if (hasExtParameterInfos()) {
      EPI.ExtParameterInfos = getExtParameterInfosBuffer();
    }
    return EPI;
  }

  
  /// Get the kind of exception specification on this function.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExceptionSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3304,
   FQN="clang::FunctionProtoType::getExceptionSpecType", NM="_ZNK5clang17FunctionProtoType20getExceptionSpecTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType20getExceptionSpecTypeEv")
  //</editor-fold>
  public ExceptionSpecificationType getExceptionSpecType() /*const*/ {
    return /*static_cast*/ExceptionSpecificationType.valueOf(ExceptionSpecType);
  }

  /// Return whether this function has any kind of exception spec.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::hasExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3308,
   FQN="clang::FunctionProtoType::hasExceptionSpec", NM="_ZNK5clang17FunctionProtoType16hasExceptionSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType16hasExceptionSpecEv")
  //</editor-fold>
  public boolean hasExceptionSpec() /*const*/ {
    return getExceptionSpecType() != ExceptionSpecificationType.EST_None;
  }

  /// Return whether this function has a dynamic (throw) exception spec.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::hasDynamicExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3312,
   FQN="clang::FunctionProtoType::hasDynamicExceptionSpec", NM="_ZNK5clang17FunctionProtoType23hasDynamicExceptionSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType23hasDynamicExceptionSpecEv")
  //</editor-fold>
  public boolean hasDynamicExceptionSpec() /*const*/ {
    return isDynamicExceptionSpec(getExceptionSpecType());
  }

  /// Return whether this function has a noexcept exception spec.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::hasNoexceptExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3316,
   FQN="clang::FunctionProtoType::hasNoexceptExceptionSpec", NM="_ZNK5clang17FunctionProtoType24hasNoexceptExceptionSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType24hasNoexceptExceptionSpecEv")
  //</editor-fold>
  public boolean hasNoexceptExceptionSpec() /*const*/ {
    return isNoexceptExceptionSpec(getExceptionSpecType());
  }

  /// Return whether this function has a dependent exception spec.
  /// Return whether this function has a dependent exception spec.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::hasDependentExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2739,
   FQN="clang::FunctionProtoType::hasDependentExceptionSpec", NM="_ZNK5clang17FunctionProtoType25hasDependentExceptionSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17FunctionProtoType25hasDependentExceptionSpecEv")
  //</editor-fold>
  public boolean hasDependentExceptionSpec() /*const*/ {
    {
      Expr /*P*/ NE = getNoexceptExpr();
      if ((NE != null)) {
        return NE.isValueDependent();
      }
    }
    for (QualType ET : exceptions())  {
      // A pack expansion with a non-dependent pattern is still dependent,
      // because we don't know whether the pattern is in the exception spec
      // or not (that depends on whether the pack has 0 expansions).
      if (ET.$arrow().isDependentType() || (ET.$arrow().getAs(PackExpansionType.class) != null)) {
        return true;
      }
    }
    return false;
  }


  /// Result type of getNoexceptSpec().
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::NoexceptResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3322,
   FQN="clang::FunctionProtoType::NoexceptResult", NM="_ZN5clang17FunctionProtoType14NoexceptResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType14NoexceptResultE")
  //</editor-fold>
  public enum NoexceptResult implements Native.ComparableLower {
    NR_NoNoexcept(0), ///< There is no noexcept specifier.
    NR_BadNoexcept(NR_NoNoexcept.getValue() + 1), ///< The noexcept specifier has a bad expression.
    NR_Dependent(NR_BadNoexcept.getValue() + 1), ///< The noexcept specifier is dependent.
    NR_Throw(NR_Dependent.getValue() + 1), ///< The noexcept specifier evaluates to false.
    NR_Nothrow(NR_Throw.getValue() + 1); ///< The noexcept specifier evaluates to true.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NoexceptResult valueOf(int val) {
      NoexceptResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NoexceptResult[] VALUES;
      private static final NoexceptResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NoexceptResult kind : NoexceptResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NoexceptResult[min < 0 ? (1-min) : 0];
        VALUES = new NoexceptResult[max >= 0 ? (1+max) : 0];
        for (NoexceptResult kind : NoexceptResult.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private NoexceptResult(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NoexceptResult)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NoexceptResult)obj).value);}
    //</editor-fold>
  };
  /// Get the meaning of the noexcept spec on this function, if any.
  /// Get the meaning of the noexcept spec on this function, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getNoexceptSpec">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2751,
   FQN="clang::FunctionProtoType::getNoexceptSpec", NM="_ZNK5clang17FunctionProtoType15getNoexceptSpecERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17FunctionProtoType15getNoexceptSpecERKNS_10ASTContextE")
  //</editor-fold>
  public FunctionProtoType.NoexceptResult getNoexceptSpec(final /*const*/ ASTContext /*&*/ ctx) /*const*/ {
    ExceptionSpecificationType est = getExceptionSpecType();
    if (est == ExceptionSpecificationType.EST_BasicNoexcept) {
      return NoexceptResult.NR_Nothrow;
    }
    if (est != ExceptionSpecificationType.EST_ComputedNoexcept) {
      return NoexceptResult.NR_NoNoexcept;
    }
    
    Expr /*P*/ noexceptExpr = getNoexceptExpr();
    if (!(noexceptExpr != null)) {
      return NoexceptResult.NR_BadNoexcept;
    }
    if (noexceptExpr.isValueDependent()) {
      return NoexceptResult.NR_Dependent;
    }
    
    APSInt value/*J*/= new APSInt();
    boolean isICE = noexceptExpr.isIntegerConstantExpr(value, ctx, (type$ptr<SourceLocation> /*P*/ )null, 
        /*evaluated*/ false);
    //Java /*J:(void)*/isICE;
    assert (isICE) : "AST should not contain bad noexcept expressions.";
    
    return value.getBoolValue() ? NoexceptResult.NR_Nothrow : NoexceptResult.NR_Throw;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getNumExceptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3331,
   FQN="clang::FunctionProtoType::getNumExceptions", NM="_ZNK5clang17FunctionProtoType16getNumExceptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType16getNumExceptionsEv")
  //</editor-fold>
  public /*uint*/int getNumExceptions() /*const*/ {
    return NumExceptions;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExceptionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3332,
   FQN="clang::FunctionProtoType::getExceptionType", NM="_ZNK5clang17FunctionProtoType16getExceptionTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType16getExceptionTypeEj")
  //</editor-fold>
  public QualType getExceptionType(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumExceptions)) : "Invalid exception number!";
    return new QualType(exception_begin().$at(i));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3336,
   FQN="clang::FunctionProtoType::getNoexceptExpr", NM="_ZNK5clang17FunctionProtoType15getNoexceptExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType15getNoexceptExprEv")
  //</editor-fold>
  public Expr /*P*/ getNoexceptExpr() /*const*/ {
    if (getExceptionSpecType() != ExceptionSpecificationType.EST_ComputedNoexcept) {
      return null;
    }
    // NoexceptExpr sits where the arguments end.
    return ((type$ptr<Expr /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, param_type_end())).$star();
  }

  /// \brief If this function type has an exception specification which hasn't
  /// been determined yet (either because it has not been evaluated or because
  /// it has not been instantiated), this is the function whose exception
  /// specification is represented by this type.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExceptionSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3346,
   FQN="clang::FunctionProtoType::getExceptionSpecDecl", NM="_ZNK5clang17FunctionProtoType20getExceptionSpecDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType20getExceptionSpecDeclEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getExceptionSpecDecl() /*const*/ {
    if (getExceptionSpecType() != ExceptionSpecificationType.EST_Uninstantiated
       && getExceptionSpecType() != ExceptionSpecificationType.EST_Unevaluated) {
      return null;
    }
    return ((type$ptr<FunctionDecl /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, param_type_end())).$at(0);
  }

  /// \brief If this function type has an uninstantiated exception
  /// specification, this is the function whose exception specification
  /// should be instantiated to find the exception specification for
  /// this type.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExceptionSpecTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3356,
   FQN="clang::FunctionProtoType::getExceptionSpecTemplate", NM="_ZNK5clang17FunctionProtoType24getExceptionSpecTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType24getExceptionSpecTemplateEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getExceptionSpecTemplate() /*const*/ {
    if (getExceptionSpecType() != ExceptionSpecificationType.EST_Uninstantiated) {
      return null;
    }
    return ((type$ptr<FunctionDecl /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, param_type_end())).$at(1);
  }

  /// Determine whether this function type has a non-throwing exception
  /// specification. If this depends on template arguments, returns
  /// \c ResultIfDependent.
  /// Determine whether this function type has a non-throwing exception
  /// specification. If this depends on template arguments, returns
  /// \c ResultIfDependent.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::isNothrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2775,
   FQN="clang::FunctionProtoType::isNothrow", NM="_ZNK5clang17FunctionProtoType9isNothrowERKNS_10ASTContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17FunctionProtoType9isNothrowERKNS_10ASTContextEb")
  //</editor-fold>
  public boolean isNothrow(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return isNothrow(Ctx, 
           false);
  }
  public boolean isNothrow(final /*const*/ ASTContext /*&*/ Ctx, 
           boolean ResultIfDependent/*= false*/) /*const*/ {
    ExceptionSpecificationType EST = getExceptionSpecType();
    assert (EST != ExceptionSpecificationType.EST_Unevaluated && EST != ExceptionSpecificationType.EST_Uninstantiated);
    if (EST == ExceptionSpecificationType.EST_DynamicNone || EST == ExceptionSpecificationType.EST_BasicNoexcept) {
      return true;
    }
    if (EST == ExceptionSpecificationType.EST_Dynamic && ResultIfDependent) {
      // A dynamic exception specification is throwing unless every exception
      // type is an (unexpanded) pack expansion type.
      for (/*uint*/int I = 0, N = NumExceptions; I != N; ++I)  {
        if (!(getExceptionType(I).$arrow().getAs(PackExpansionType.class) != null)) {
          return false;
        }
      }
      return ResultIfDependent;
    }
    if (EST != ExceptionSpecificationType.EST_ComputedNoexcept) {
      return false;
    }
    
    NoexceptResult NR = getNoexceptSpec(Ctx);
    if (NR == NoexceptResult.NR_Dependent) {
      return ResultIfDependent;
    }
    return NR == NoexceptResult.NR_Nothrow;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::isVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3366,
   FQN="clang::FunctionProtoType::isVariadic", NM="_ZNK5clang17FunctionProtoType10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType10isVariadicEv")
  //</editor-fold>
  public boolean isVariadic() /*const*/ {
    return Variadic;
  }

  
  /// Determines whether this function prototype contains a
  /// parameter pack at the end.
  ///
  /// A function template whose last parameter is a parameter pack can be
  /// called with an arbitrary number of arguments, much like a variadic
  /// function.
  
  /// Determines whether this function prototype contains a
  /// parameter pack at the end.
  ///
  /// A function template whose last parameter is a parameter pack can be
  /// called with an arbitrary number of arguments, much like a variadic
  /// function.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::isTemplateVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2800,
   FQN="clang::FunctionProtoType::isTemplateVariadic", NM="_ZNK5clang17FunctionProtoType18isTemplateVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17FunctionProtoType18isTemplateVariadicEv")
  //</editor-fold>
  public boolean isTemplateVariadic() /*const*/ {
    for (/*uint*/int ArgIdx = getNumParams(); (ArgIdx != 0); --ArgIdx)  {
      if (isa_PackExpansionType(getParamType(ArgIdx - 1))) {
        return true;
      }
    }
    
    return false;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::hasTrailingReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3376,
   FQN="clang::FunctionProtoType::hasTrailingReturn", NM="_ZNK5clang17FunctionProtoType17hasTrailingReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType17hasTrailingReturnEv")
  //</editor-fold>
  public boolean hasTrailingReturn() /*const*/ {
    return HasTrailingReturn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getTypeQuals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3378,
   FQN="clang::FunctionProtoType::getTypeQuals", NM="_ZNK5clang17FunctionProtoType12getTypeQualsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType12getTypeQualsEv")
  //</editor-fold>
  public /*uint*/int getTypeQuals() /*const*/ {
    return super.getTypeQuals();
  }

  
  /// Retrieve the ref-qualifier associated with this function type.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getRefQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3382,
   FQN="clang::FunctionProtoType::getRefQualifier", NM="_ZNK5clang17FunctionProtoType15getRefQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType15getRefQualifierEv")
  //</editor-fold>
  public RefQualifierKind getRefQualifier() /*const*/ {
    return /*static_cast*/RefQualifierKind.valueOf(Unnamed_field.FunctionTypeBits.RefQualifier);
  }

  
  /*typedef const QualType *param_type_iterator*/
//  public final class param_type_iterator extends /*const*/type$ptr<QualType /*P*/> { };
  /*typedef llvm::iterator_range<param_type_iterator> param_type_range*/
//  public final class param_type_range extends iterator_range</*const*/ QualType>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::param_types">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3389,
   FQN="clang::FunctionProtoType::param_types", NM="_ZNK5clang17FunctionProtoType11param_typesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType11param_typesEv")
  //</editor-fold>
  public iterator_range</*const*/ QualType> param_types() /*const*/ {
    return new iterator_range</*const*/ QualType>(param_type_begin(), param_type_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::param_type_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3392,
   FQN="clang::FunctionProtoType::param_type_begin", NM="_ZNK5clang17FunctionProtoType16param_type_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType16param_type_beginEv")
  //</editor-fold>
  public type$ptr<QualType> param_type_begin() /*const*/ {
    type$ptr res = $tryClone(this$plus$1);
    return (type$ptr<QualType>)res;//((/*const*/type$ptr<QualType /*P*/> )reinterpret_cast(/*const*/type$ptr.class, this + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::param_type_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3395,
   FQN="clang::FunctionProtoType::param_type_end", NM="_ZNK5clang17FunctionProtoType14param_type_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType14param_type_endEv")
  //</editor-fold>
  public type$ptr<QualType> param_type_end() /*const*/ {
    return param_type_begin().$add(NumParams);
  }

  
  /*typedef const QualType *exception_iterator*/
//  public final class exception_iterator extends /*const*/type$ptr<QualType /*P*/> { };
  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::exceptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3401,
   FQN="clang::FunctionProtoType::exceptions", NM="_ZNK5clang17FunctionProtoType10exceptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType10exceptionsEv")
  //</editor-fold>
  public ArrayRef<QualType> exceptions() /*const*/ {
    return llvm.makeArrayRef(exception_begin(), exception_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::exception_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3404,
   FQN="clang::FunctionProtoType::exception_begin", NM="_ZNK5clang17FunctionProtoType15exception_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType15exception_beginEv")
  //</editor-fold>
  public type$ptr<QualType> exception_begin() /*const*/ {
    // exceptions begin where arguments end
    return param_type_end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::exception_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3408,
   FQN="clang::FunctionProtoType::exception_end", NM="_ZNK5clang17FunctionProtoType13exception_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType13exception_endEv")
  //</editor-fold>
  public type$ptr<QualType> exception_end() /*const*/ {
    if (getExceptionSpecType() != ExceptionSpecificationType.EST_Dynamic) {
      return exception_begin();
    }
    return exception_begin().$add(NumExceptions);
  }

  
  /// Is there any interesting extra information for any of the parameters
  /// of this function type?
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::hasExtParameterInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3416,
   FQN="clang::FunctionProtoType::hasExtParameterInfos", NM="_ZNK5clang17FunctionProtoType20hasExtParameterInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType20hasExtParameterInfosEv")
  //</editor-fold>
  public boolean hasExtParameterInfos() /*const*/ {
    return HasExtParameterInfos;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExtParameterInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3417,
   FQN="clang::FunctionProtoType::getExtParameterInfos", NM="_ZNK5clang17FunctionProtoType20getExtParameterInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType20getExtParameterInfosEv")
  //</editor-fold>
  public ArrayRef<ExtParameterInfo> getExtParameterInfos() /*const*/ {
    assert (hasExtParameterInfos());
    return new ArrayRef<ExtParameterInfo>(getExtParameterInfosBuffer(), 
        getNumParams(), false);
  }

  /// Return a pointer to the beginning of the array of extra parameter
  /// information, if present, or else null if none of the parameters
  /// carry it.  This is equivalent to getExtProtoInfo().ExtParameterInfos.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExtParameterInfosOrNull">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3425,
   FQN="clang::FunctionProtoType::getExtParameterInfosOrNull", NM="_ZNK5clang17FunctionProtoType26getExtParameterInfosOrNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType26getExtParameterInfosOrNullEv")
  //</editor-fold>
  public /*const*/ type$ptr<ExtParameterInfo /*P*/> getExtParameterInfosOrNull() /*const*/ {
    if (!hasExtParameterInfos()) {
      return null;
    }
    return getExtParameterInfosBuffer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getExtParameterInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3431,
   FQN="clang::FunctionProtoType::getExtParameterInfo", NM="_ZNK5clang17FunctionProtoType19getExtParameterInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType19getExtParameterInfoEj")
  //</editor-fold>
  public ExtParameterInfo getExtParameterInfo(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumParams())) : "parameter index out of range";
    if (hasExtParameterInfos()) {
      return new ExtParameterInfo(getExtParameterInfosBuffer().$at(I));
    }
    return new ExtParameterInfo();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::getParameterABI">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3438,
   FQN="clang::FunctionProtoType::getParameterABI", NM="_ZNK5clang17FunctionProtoType15getParameterABIEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType15getParameterABIEj")
  //</editor-fold>
  public ParameterABI getParameterABI(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumParams())) : "parameter index out of range";
    if (hasExtParameterInfos()) {
      return getExtParameterInfosBuffer().$at(I).getABI();
    }
    return ParameterABI.Ordinary;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::isParamConsumed">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3445,
   FQN="clang::FunctionProtoType::isParamConsumed", NM="_ZNK5clang17FunctionProtoType15isParamConsumedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType15isParamConsumedEj")
  //</editor-fold>
  public boolean isParamConsumed(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumParams())) : "parameter index out of range";
    if (hasExtParameterInfos()) {
      return getExtParameterInfosBuffer().$at(I).isConsumed();
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3452,
   FQN="clang::FunctionProtoType::isSugared", NM="_ZNK5clang17FunctionProtoType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3453,
   FQN="clang::FunctionProtoType::desugar", NM="_ZNK5clang17FunctionProtoType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang17FunctionProtoType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::printExceptionSpecification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 593,
   FQN="clang::FunctionProtoType::printExceptionSpecification", NM="_ZNK5clang17FunctionProtoType27printExceptionSpecificationERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZNK5clang17FunctionProtoType27printExceptionSpecificationERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printExceptionSpecification(final raw_ostream /*&*/ OS, 
                             final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    if (hasDynamicExceptionSpec()) {
      OS.$out(/*KEEP_STR*/" throw(");
      if (getExceptionSpecType() == ExceptionSpecificationType.EST_MSAny) {
        OS.$out(/*KEEP_STR*/$ELLIPSIS);
      } else {
        for (/*uint*/int I = 0, N = getNumExceptions(); I != N; ++I) {
          if ((I != 0)) {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          
          $out_raw_ostream_StreamedQualTypeHelper$C(OS, getExceptionType(I).stream(Policy));
        }
      }
      OS.$out_char($$RPAREN);
    } else if (isNoexceptExceptionSpec(getExceptionSpecType())) {
      OS.$out(/*KEEP_STR*/" noexcept");
      if (getExceptionSpecType() == ExceptionSpecificationType.EST_ComputedNoexcept) {
        OS.$out_char($$LPAREN);
        if ((getNoexceptExpr() != null)) {
          getNoexceptExpr().printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        }
        OS.$out_char($$RPAREN);
      }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3458,
   FQN="clang::FunctionProtoType::classof", NM="_ZN5clang17FunctionProtoType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang17FunctionProtoType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.FunctionProto;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2863,
   FQN="clang::FunctionProtoType::Profile", NM="_ZN5clang17FunctionProtoType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17FunctionProtoType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID, 
         final /*const*/ ASTContext /*&*/ Ctx) {
    Profile(ID, getReturnType(), param_type_begin(), NumParams, getExtProtoInfo(), 
        Ctx);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FunctionProtoType::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2808,
   FQN="clang::FunctionProtoType::Profile", NM="_ZN5clang17FunctionProtoType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeEPKS4_jRKNS0_12ExtProtoInfoERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17FunctionProtoType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeEPKS4_jRKNS0_12ExtProtoInfoERKNS_10ASTContextE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType Result, 
         /*const*/type$ptr<QualType /*P*/> ArgTys, /*uint*/int NumParams, 
         final /*const*/ ExtProtoInfo /*&*/ epi, 
         final /*const*/ ASTContext /*&*/ Context) {
    
    // We have to be careful not to get ambiguous profile encodings.
    // Note that valid type pointers are never ambiguous with anything else.
    //
    // The encoding grammar begins:
    //      type type* bool int bool 
    // If that final bool is true, then there is a section for the EH spec:
    //      bool type*
    // This is followed by an optional "consumed argument" section of the
    // same length as the first type sequence:
    //      bool*
    // Finally, we have the ext info and trailing return type flag:
    //      int bool
    // 
    // There is no ambiguity between the consumed arguments and an empty EH
    // spec because of the leading 'bool' which unambiguously indicates
    // whether the following bool is the EH spec or part of the arguments.
    ID.AddPointer(Result.getAsOpaquePtr());
    for (/*uint*/int i = 0; i != NumParams; ++i)  {
      ID.AddPointer(ArgTys.$at(i).getAsOpaquePtr());
    }
    // This method is relatively performance sensitive, so as a performance
    // shortcut, use one AddInteger call instead of four for the next four
    // fields.
    assert (!((((/*uint*/int)((epi.Variadic ? 1 : 0))) & ~1) != 0) && !((((/*uint*/int)($uchar2uint(epi.TypeQuals))) & ~255) != 0) && !((((/*uint*/int)(epi.RefQualifier.getValue())) & ~3) != 0) && !((((/*uint*/int)(epi.ExceptionSpec.Type.getValue())) & ~15) != 0)) : "Values larger than expected.";
    ID.AddInteger_uint(((/*uint*/int)((epi.Variadic ? 1 : 0)))
           + ($uchar2int(epi.TypeQuals) << 1)
           + (epi.RefQualifier.getValue() << 9)
           + (epi.ExceptionSpec.Type.getValue() << 11));
    if (epi.ExceptionSpec.Type == ExceptionSpecificationType.EST_Dynamic) {
      for (QualType Ex : epi.ExceptionSpec.Exceptions)  {
        ID.AddPointer(Ex.getAsOpaquePtr());
      }
    } else if (epi.ExceptionSpec.Type == ExceptionSpecificationType.EST_ComputedNoexcept
       && (epi.ExceptionSpec.NoexceptExpr != null)) {
      epi.ExceptionSpec.NoexceptExpr.Profile(ID, Context, false);
    } else if (epi.ExceptionSpec.Type == ExceptionSpecificationType.EST_Uninstantiated
       || epi.ExceptionSpec.Type == ExceptionSpecificationType.EST_Unevaluated) {
      ID.AddPointer(epi.ExceptionSpec.SourceDecl.getCanonicalDecl());
    }
    if ((epi.ExtParameterInfos != null)) {
      for (/*uint*/int i = 0; i != NumParams; ++i)  {
        ID.AddInteger_int($uchar2int(epi.ExtParameterInfos.$at(i).getOpaqueValue()));
      }
    }
    epi.ExtInfo.Profile(ID);
    ID.AddBoolean(epi.HasTrailingReturn);
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr<? /*P*/> this$plus$1;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumParams=" + $ushort2uint(NumParams) // NOI18N
              + ", NumExceptions=" + $ushort2uint(NumExceptions) // NOI18N
              + ", ExceptionSpecType=" + $uchar2uint(ExceptionSpecType) // NOI18N
              + ", HasExtParameterInfos=" + HasExtParameterInfos // NOI18N
              + ", Variadic=" + Variadic // NOI18N
              + ", HasTrailingReturn=" + HasTrailingReturn // NOI18N
              + super.toString(); // NOI18N
  }
}
