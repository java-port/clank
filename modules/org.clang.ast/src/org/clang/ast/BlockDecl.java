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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.DeclContext.*;


/// BlockDecl - This represents a block literal declaration, which is like an
/// unnamed FunctionDecl.  For example:
/// ^{ statement-body }   or   ^(int arg1, float arg2){ statement-body }
///
//<editor-fold defaultstate="collapsed" desc="clang::BlockDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3456,
 FQN="clang::BlockDecl", NM="_ZN5clang9BlockDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDeclE")
//</editor-fold>
public class BlockDecl extends /*public*/ Decl implements /*public*/ DeclContext, Destructors.ClassWithDestructor {
/*public:*/
  /// A class which contains all the information about a particular
  /// captured value.
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3460,
   FQN="clang::BlockDecl::Capture", NM="_ZN5clang9BlockDecl7CaptureE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl7CaptureE")
  //</editor-fold>
  public static class Capture implements NativeCloneable<Capture> {

    
    //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3461,
     FQN="clang::BlockDecl::Capture::(anonymous)", NM="_ZN5clang9BlockDecl7CaptureE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl7CaptureE_Unnamed_enum")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int flag_isByRef = 0x1;
      public static final /*uint*/int flag_isNested = 0x2;
    /*}*/;
    
    /// The variable being captured.
    private PointerIntPair<VarDecl /*P*/ > VariableAndFlags;
    
    /// The copy expression, expressed in terms of a DeclRef (or
    /// BlockDeclRef) to the captured variable.  Only required if the
    /// variable has a C++ class type.
    private Expr /*P*/ CopyExpr;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture::Capture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3475,
     FQN="clang::BlockDecl::Capture::Capture", NM="_ZN5clang9BlockDecl7CaptureC1EPNS_7VarDeclEbbPNS_4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl7CaptureC1EPNS_7VarDeclEbbPNS_4ExprE")
    //</editor-fold>
    public Capture(VarDecl /*P*/ variable, boolean byRef, boolean nested, Expr /*P*/ copy) {
      // : VariableAndFlags(variable, (byRef ? flag_isByRef : 0) | (nested ? flag_isNested : 0)), CopyExpr(copy) 
      //START JInit
      this.VariableAndFlags = new PointerIntPair<VarDecl /*P*/ >(variable, 
          (byRef ? flag_isByRef : 0) | (nested ? flag_isNested : 0));
      this.CopyExpr = copy;
      //END JInit
    }

    
    /// The variable being captured.
    //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture::getVariable">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3481,
     FQN="clang::BlockDecl::Capture::getVariable", NM="_ZNK5clang9BlockDecl7Capture11getVariableEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl7Capture11getVariableEv")
    //</editor-fold>
    public VarDecl /*P*/ getVariable() /*const*/ {
      return VariableAndFlags.getPointer();
    }

    
    /// Whether this is a "by ref" capture, i.e. a capture of a __block
    /// variable.
    //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture::isByRef">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3485,
     FQN="clang::BlockDecl::Capture::isByRef", NM="_ZNK5clang9BlockDecl7Capture7isByRefEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl7Capture7isByRefEv")
    //</editor-fold>
    public boolean isByRef() /*const*/ {
      return ((VariableAndFlags.getInt() & flag_isByRef) != 0);
    }

    
    /// Whether this is a nested capture, i.e. the variable captured
    /// is not from outside the immediately enclosing function/block.
    //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture::isNested">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3489,
     FQN="clang::BlockDecl::Capture::isNested", NM="_ZNK5clang9BlockDecl7Capture8isNestedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl7Capture8isNestedEv")
    //</editor-fold>
    public boolean isNested() /*const*/ {
      return ((VariableAndFlags.getInt() & flag_isNested) != 0);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture::hasCopyExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3491,
     FQN="clang::BlockDecl::Capture::hasCopyExpr", NM="_ZNK5clang9BlockDecl7Capture11hasCopyExprEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl7Capture11hasCopyExprEv")
    //</editor-fold>
    public boolean hasCopyExpr() /*const*/ {
      return CopyExpr != null;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture::getCopyExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3492,
     FQN="clang::BlockDecl::Capture::getCopyExpr", NM="_ZNK5clang9BlockDecl7Capture11getCopyExprEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl7Capture11getCopyExprEv")
    //</editor-fold>
    public Expr /*P*/ getCopyExpr() /*const*/ {
      return CopyExpr;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture::setCopyExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3493,
     FQN="clang::BlockDecl::Capture::setCopyExpr", NM="_ZN5clang9BlockDecl7Capture11setCopyExprEPNS_4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl7Capture11setCopyExprEPNS_4ExprE")
    //</editor-fold>
    public void setCopyExpr(Expr /*P*/ e) {
      CopyExpr = e;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Capture::Capture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3460,
     FQN="clang::BlockDecl::Capture::Capture", NM="_ZN5clang9BlockDecl7CaptureC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9BlockDecl7CaptureC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Capture(final /*const*/ Capture /*&*/ $Prm0) {
      // : VariableAndFlags(.VariableAndFlags), CopyExpr(.CopyExpr) 
      //START JInit
      this.VariableAndFlags = new PointerIntPair<VarDecl /*P*/ >($Prm0.VariableAndFlags);
      this.CopyExpr = $Prm0.CopyExpr;
      //END JInit
    }

    public Capture() {
      this.VariableAndFlags = new PointerIntPair<VarDecl /*P*/ >();
    }
    
    @Override public Capture clone() { 
      return new Capture(this); 
    }
    
    @Override public String toString() {
      return "" + "VariableAndFlags=" + VariableAndFlags // NOI18N
                + ", CopyExpr=" + CopyExpr; // NOI18N
    }
  };
/*private:*/
  // FIXME: This can be packed into the bitfields in Decl.
  private /*JBIT bool*/ boolean IsVariadic /*: 1*/;
  private /*JBIT bool*/ boolean CapturesCXXThis /*: 1*/;
  private /*JBIT bool*/ boolean BlockMissingReturnType /*: 1*/;
  private /*JBIT bool*/ boolean IsConversionFromLambda /*: 1*/;
  /// ParamInfo - new[]'d array of pointers to ParmVarDecls for the formal
  /// parameters of this function.  This is null if a prototype or if there are
  /// no formals.
  private type$ptr<ParmVarDecl /*P*/ /*P*/> ParamInfo;
  private /*uint*/int NumParams;
  
  private Stmt /*P*/ Body;
  private TypeSourceInfo /*P*/ SignatureAsWritten;
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private /*const*/ type$ptr<Capture /*P*/> Captures;
  private /*uint*/int NumCaptures;
  
  private /*uint*/int ManglingNumber;
  private Decl /*P*/ ManglingContextDecl;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::BlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3518,
   FQN="clang::BlockDecl::BlockDecl", NM="_ZN5clang9BlockDeclC1EPNS_11DeclContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDeclC1EPNS_11DeclContextENS_14SourceLocationE")
  //</editor-fold>
  protected BlockDecl(DeclContext /*P*/ DC, SourceLocation CaretLoc) {
    // : Decl(Block, DC, CaretLoc), DeclContext(Block), IsVariadic(false), CapturesCXXThis(false), BlockMissingReturnType(true), IsConversionFromLambda(false), ParamInfo(null), NumParams(0), Body(null), SignatureAsWritten(null), Captures(null), NumCaptures(0), ManglingNumber(0), ManglingContextDecl(null) 
    //START JInit
    super(Kind.Block, DC, new SourceLocation(CaretLoc));
    this.DeclContext$Flds = $DeclContext(Kind.Block);
    this.IsVariadic = false;
    this.CapturesCXXThis = false;
    this.BlockMissingReturnType = true;
    this.IsConversionFromLambda = false;
    this.ParamInfo = null;
    this.NumParams = 0;
    this.Body = null;
    this.SignatureAsWritten = null;
    this.Captures = null;
    this.NumCaptures = 0;
    this.ManglingNumber = 0;
    this.ManglingContextDecl = null;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4050,
   FQN="clang::BlockDecl::Create", NM="_ZN5clang9BlockDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9BlockDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationE")
  //</editor-fold>
  public static BlockDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation L) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new BlockDecl(DC, new SourceLocation(L));
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4054,
   FQN="clang::BlockDecl::CreateDeserialized", NM="_ZN5clang9BlockDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9BlockDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static BlockDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new BlockDecl((DeclContext /*P*/ )null, new SourceLocation());
     });
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getCaretLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3530,
   FQN="clang::BlockDecl::getCaretLocation", NM="_ZNK5clang9BlockDecl16getCaretLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl16getCaretLocationEv")
  //</editor-fold>
  public SourceLocation getCaretLocation() /*const*/ {
    return getLocation();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::isVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3532,
   FQN="clang::BlockDecl::isVariadic", NM="_ZNK5clang9BlockDecl10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl10isVariadicEv")
  //</editor-fold>
  public boolean isVariadic() /*const*/ {
    return IsVariadic;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::setIsVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3533,
   FQN="clang::BlockDecl::setIsVariadic", NM="_ZN5clang9BlockDecl13setIsVariadicEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl13setIsVariadicEb")
  //</editor-fold>
  public void setIsVariadic(boolean value) {
    IsVariadic = value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getCompoundBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3535,
   FQN="clang::BlockDecl::getCompoundBody", NM="_ZNK5clang9BlockDecl15getCompoundBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl15getCompoundBodyEv")
  //</editor-fold>
  public CompoundStmt /*P*/ getCompoundBody() /*const*/ {
    return (CompoundStmt /*P*/ )Body;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3536,
   FQN="clang::BlockDecl::getBody", NM="_ZNK5clang9BlockDecl7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl7getBodyEv")
  //</editor-fold>
  @Override public Stmt /*P*/ getBody() /*const*//* override*/ {
    return (Stmt /*P*/ )Body;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3537,
   FQN="clang::BlockDecl::setBody", NM="_ZN5clang9BlockDecl7setBodyEPNS_12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl7setBodyEPNS_12CompoundStmtE")
  //</editor-fold>
  public void setBody(CompoundStmt /*P*/ B) {
    Body = (Stmt /*P*/ )B;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::setSignatureAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3539,
   FQN="clang::BlockDecl::setSignatureAsWritten", NM="_ZN5clang9BlockDecl21setSignatureAsWrittenEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl21setSignatureAsWrittenEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setSignatureAsWritten(TypeSourceInfo /*P*/ Sig) {
    SignatureAsWritten = Sig;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getSignatureAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3540,
   FQN="clang::BlockDecl::getSignatureAsWritten", NM="_ZNK5clang9BlockDecl21getSignatureAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl21getSignatureAsWrittenEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getSignatureAsWritten() /*const*/ {
    return SignatureAsWritten;
  }

  
  // ArrayRef access to formal parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3543,
   FQN="clang::BlockDecl::parameters", NM="_ZNK5clang9BlockDecl10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl10parametersEv")
  //</editor-fold>
  public ArrayRef<ParmVarDecl /*P*/ > parameters$Const() /*const*/ {
    return /*{ */new ArrayRef<ParmVarDecl /*P*/ >(ParamInfo, getNumParams(), true)/* }*/;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3546,
   FQN="clang::BlockDecl::parameters", NM="_ZN5clang9BlockDecl10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl10parametersEv")
  //</editor-fold>
  public MutableArrayRef<ParmVarDecl /*P*/ > parameters() {
    return /*{ */new MutableArrayRef<ParmVarDecl /*P*/ >(ParamInfo, getNumParams(), true)/* }*/;
  }

  
  // Iterator access to formal parameters.
  /*typedef MutableArrayRef<ParmVarDecl *>::iterator param_iterator*/
//  public final class param_iterator extends type$ptr<ParmVarDecl /*P*/ /*P*/>{ };
  /*typedef ArrayRef<ParmVarDecl *>::const_iterator param_const_iterator*/
//  public final class param_const_iterator extends type$ptr<ParmVarDecl /*P*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::param_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3553,
   FQN="clang::BlockDecl::param_empty", NM="_ZNK5clang9BlockDecl11param_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl11param_emptyEv")
  //</editor-fold>
  public boolean param_empty() /*const*/ {
    return parameters$Const().empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::param_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3554,
   FQN="clang::BlockDecl::param_begin", NM="_ZN5clang9BlockDecl11param_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl11param_beginEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*P*/> param_begin() {
    return parameters().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::param_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3555,
   FQN="clang::BlockDecl::param_end", NM="_ZN5clang9BlockDecl9param_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl9param_endEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*P*/> param_end() {
    return parameters().end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::param_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3556,
   FQN="clang::BlockDecl::param_begin", NM="_ZNK5clang9BlockDecl11param_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl11param_beginEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*P*/> param_begin$Const() /*const*/ {
    return parameters$Const().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::param_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3557,
   FQN="clang::BlockDecl::param_end", NM="_ZNK5clang9BlockDecl9param_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl9param_endEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*P*/> param_end$Const() /*const*/ {
    return parameters$Const().end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::param_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3558,
   FQN="clang::BlockDecl::param_size", NM="_ZNK5clang9BlockDecl10param_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl10param_sizeEv")
  //</editor-fold>
  public /*size_t*/int param_size() /*const*/ {
    return parameters$Const().size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getNumParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3560,
   FQN="clang::BlockDecl::getNumParams", NM="_ZNK5clang9BlockDecl12getNumParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl12getNumParamsEv")
  //</editor-fold>
  public /*uint*/int getNumParams() /*const*/ {
    return NumParams;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3561,
   FQN="clang::BlockDecl::getParamDecl", NM="_ZNK5clang9BlockDecl12getParamDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl12getParamDeclEj")
  //</editor-fold>
  public /*const*/ ParmVarDecl /*P*/ getParamDecl$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumParams())) : "Illegal param #";
    return ParamInfo.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3565,
   FQN="clang::BlockDecl::getParamDecl", NM="_ZN5clang9BlockDecl12getParamDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl12getParamDeclEj")
  //</editor-fold>
  public ParmVarDecl /*P*/ getParamDecl(/*uint*/int i) {
    assert ($less_uint(i, getNumParams())) : "Illegal param #";
    return ParamInfo.$at(i);
  }

  
  //===----------------------------------------------------------------------===//
  // BlockDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::setParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3877,
   FQN="clang::BlockDecl::setParams", NM="_ZN5clang9BlockDecl9setParamsEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9BlockDecl9setParamsEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE")
  //</editor-fold>
  public void setParams(ArrayRef<ParmVarDecl /*P*/ > NewParamInfo) {
    assert (!Native.$bool(ParamInfo)) : "Already has param info!";
    
    // Zero params -> null pointer.
    if (!NewParamInfo.empty()) {
      NumParams = NewParamInfo.size();
      ParamInfo = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
      /*new (getASTContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new ParmVarDecl /*P*/ [NewParamInfo.size()]);
      std.copy(NewParamInfo.begin(), NewParamInfo.end(), ParamInfo);
    }
  }


  
  /// hasCaptures - True if this block (or its nested blocks) captures
  /// anything of local storage from its enclosing scopes.
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::hasCaptures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3573,
   FQN="clang::BlockDecl::hasCaptures", NM="_ZNK5clang9BlockDecl11hasCapturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl11hasCapturesEv")
  //</editor-fold>
  public boolean hasCaptures() /*const*/ {
    return NumCaptures != 0 || CapturesCXXThis;
  }

  
  /// getNumCaptures - Returns the number of captured variables.
  /// Does not include an entry for 'this'.
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getNumCaptures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3577,
   FQN="clang::BlockDecl::getNumCaptures", NM="_ZNK5clang9BlockDecl14getNumCapturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl14getNumCapturesEv")
  //</editor-fold>
  public /*uint*/int getNumCaptures() /*const*/ {
    return NumCaptures;
  }

  
  /*typedef ArrayRef<Capture>::const_iterator capture_const_iterator*/
//  public final class capture_const_iterator extends type$ptr<Capture>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::captures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3581,
   FQN="clang::BlockDecl::captures", NM="_ZNK5clang9BlockDecl8capturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl8capturesEv")
  //</editor-fold>
  public ArrayRef<Capture> captures() /*const*/ {
    return /*{ */new ArrayRef<Capture>(Captures, NumCaptures, false)/* }*/;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::capture_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3583,
   FQN="clang::BlockDecl::capture_begin", NM="_ZNK5clang9BlockDecl13capture_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl13capture_beginEv")
  //</editor-fold>
  public type$ptr<Capture> capture_begin() /*const*/ {
    return captures().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::capture_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3584,
   FQN="clang::BlockDecl::capture_end", NM="_ZNK5clang9BlockDecl11capture_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl11capture_endEv")
  //</editor-fold>
  public type$ptr<Capture> capture_end() /*const*/ {
    return captures().end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::capturesCXXThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3586,
   FQN="clang::BlockDecl::capturesCXXThis", NM="_ZNK5clang9BlockDecl15capturesCXXThisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl15capturesCXXThisEv")
  //</editor-fold>
  public boolean capturesCXXThis() /*const*/ {
    return CapturesCXXThis;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::blockMissingReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3587,
   FQN="clang::BlockDecl::blockMissingReturnType", NM="_ZNK5clang9BlockDecl22blockMissingReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl22blockMissingReturnTypeEv")
  //</editor-fold>
  public boolean blockMissingReturnType() /*const*/ {
    return BlockMissingReturnType;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::setBlockMissingReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3588,
   FQN="clang::BlockDecl::setBlockMissingReturnType", NM="_ZN5clang9BlockDecl25setBlockMissingReturnTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl25setBlockMissingReturnTypeEb")
  //</editor-fold>
  public void setBlockMissingReturnType(boolean val) {
    BlockMissingReturnType = val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::isConversionFromLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3590,
   FQN="clang::BlockDecl::isConversionFromLambda", NM="_ZNK5clang9BlockDecl22isConversionFromLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl22isConversionFromLambdaEv")
  //</editor-fold>
  public boolean isConversionFromLambda() /*const*/ {
    return IsConversionFromLambda;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::setIsConversionFromLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3591,
   FQN="clang::BlockDecl::setIsConversionFromLambda", NM="_ZN5clang9BlockDecl25setIsConversionFromLambdaEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl25setIsConversionFromLambdaEb")
  //</editor-fold>
  public void setIsConversionFromLambda(boolean val) {
    IsConversionFromLambda = val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::capturesVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3901,
   FQN="clang::BlockDecl::capturesVariable", NM="_ZNK5clang9BlockDecl16capturesVariableEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9BlockDecl16capturesVariableEPKNS_7VarDeclE")
  //</editor-fold>
  public boolean capturesVariable(/*const*/ VarDecl /*P*/ variable) /*const*/ {
    for (final /*const*/ Capture /*&*/ I : captures())  {
      // Only auto vars can be captured, so no redeclaration worries.
      if (I.getVariable() == variable) {
        return true;
      }
    }
    
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::setCaptures">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3888,
   FQN="clang::BlockDecl::setCaptures", NM="_ZN5clang9BlockDecl11setCapturesERNS_10ASTContextEN4llvm8ArrayRefINS0_7CaptureEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9BlockDecl11setCapturesERNS_10ASTContextEN4llvm8ArrayRefINS0_7CaptureEEEb")
  //</editor-fold>
  public void setCaptures(final ASTContext /*&*/ Context, ArrayRef<Capture> Captures, 
             boolean CapturesCXXThis) {
    this.CapturesCXXThis = CapturesCXXThis;
    this.NumCaptures = Captures.size();
    if (Captures.empty()) {
      this.Captures = null;
      return;
    }
    
    this.Captures = Captures.copy(Capture.class, Context).data();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getBlockManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3598,
   FQN="clang::BlockDecl::getBlockManglingNumber", NM="_ZNK5clang9BlockDecl22getBlockManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl22getBlockManglingNumberEv")
  //</editor-fold>
  public /*uint*/int getBlockManglingNumber() /*const*/ {
    return ManglingNumber;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getBlockManglingContextDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3601,
   FQN="clang::BlockDecl::getBlockManglingContextDecl", NM="_ZNK5clang9BlockDecl27getBlockManglingContextDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang9BlockDecl27getBlockManglingContextDeclEv")
  //</editor-fold>
  public Decl /*P*/ getBlockManglingContextDecl() /*const*/ {
    return ManglingContextDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::setBlockMangling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3605,
   FQN="clang::BlockDecl::setBlockMangling", NM="_ZN5clang9BlockDecl16setBlockManglingEjPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl16setBlockManglingEjPNS_4DeclE")
  //</editor-fold>
  public void setBlockMangling(/*uint*/int Number, Decl /*P*/ Ctx) {
    ManglingNumber = Number;
    ManglingContextDecl = Ctx;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3910,
   FQN="clang::BlockDecl::getSourceRange", NM="_ZNK5clang9BlockDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9BlockDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(getLocation(), (Body != null) ? Body.getLocEnd() : getLocation());
  }


  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3613,
   FQN="clang::BlockDecl::classof", NM="_ZN5clang9BlockDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3614,
   FQN="clang::BlockDecl::classofKind", NM="_ZN5clang9BlockDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.Block;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3615,
   FQN="clang::BlockDecl::castToDeclContext", NM="_ZN5clang9BlockDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ BlockDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/BlockDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3618,
   FQN="clang::BlockDecl::castFromDeclContext", NM="_ZN5clang9BlockDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9BlockDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static BlockDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/BlockDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockDecl::~BlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3456,
   FQN="clang::BlockDecl::~BlockDecl", NM="_ZN5clang9BlockDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9BlockDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
  }


  
  private final DeclContext$Fields DeclContext$Flds;// use return value of $DeclContext();
  @Override public final DeclContext$Fields $DeclContext$Fields() { return DeclContext$Flds; }
  
  @Override public String toString() {
    return "" + "IsVariadic=" + IsVariadic // NOI18N
              + ", CapturesCXXThis=" + CapturesCXXThis // NOI18N
              + ", BlockMissingReturnType=" + BlockMissingReturnType // NOI18N
              + ", IsConversionFromLambda=" + IsConversionFromLambda // NOI18N
              + ", ParamInfo=" + ParamInfo // NOI18N
              + ", NumParams=" + NumParams // NOI18N
              + ", Body=" + Body // NOI18N
              + ", SignatureAsWritten=" + SignatureAsWritten // NOI18N
              + ", Captures=" + Captures // NOI18N
              + ", NumCaptures=" + NumCaptures // NOI18N
              + ", ManglingNumber=" + ManglingNumber // NOI18N
              + ", ManglingContextDecl=" + ManglingContextDecl // NOI18N
              + super.toString(); // NOI18N
  }
}
