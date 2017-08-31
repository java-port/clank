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

package org.clang.rewrite.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.rewrite.core.*;
import org.clang.rewrite.frontend.impl.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 38,
 FQN="(anonymous namespace)::RewriteObjC", NM="_ZN12_GLOBAL__N_111RewriteObjCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjCE")
//</editor-fold>
public abstract class RewriteObjC extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 40,
   FQN="(anonymous namespace)::RewriteObjC::(anonymous)", NM="_ZN12_GLOBAL__N_111RewriteObjCE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjCE_Unnamed_enum")
  //</editor-fold>
  protected enum Unnamed_enum implements Native.ComparableLower {
    BLOCK_FIELD_IS_OBJECT(3), /* id, NSObject, __attribute__((NSObject)),
    block, ... */
    BLOCK_FIELD_IS_BLOCK(7), /* a block variable */
    BLOCK_FIELD_IS_BYREF(8), /* the on stack structure holding the 
    __block variable */
    BLOCK_FIELD_IS_WEAK(16), /* declared __weak, only used in byref copy
    helpers */
    BLOCK_BYREF_CALLER(128), /* called from __block (byref) copy/dispose
    support routines */
    BLOCK_BYREF_CURRENT_MAX(256);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 53,
   FQN="(anonymous namespace)::RewriteObjC::(anonymous)", NM="_ZN12_GLOBAL__N_111RewriteObjCE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjCE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int BLOCK_NEEDS_FREE = (1 << 24);
    public static final /*uint*/int BLOCK_HAS_COPY_DISPOSE = (1 << 25);
    public static final /*uint*/int BLOCK_HAS_CXX_OBJ = (1 << 26);
    public static final /*uint*/int BLOCK_IS_GC = (1 << 27);
    public static final /*uint*/int BLOCK_IS_GLOBAL = (1 << 28);
    public static final /*uint*/int BLOCK_HAS_DESCRIPTOR = (1 << 29);
  /*}*/;
  protected static /*const*/int OBJC_ABI_VERSION = 7;
  
  protected Rewriter Rewrite;
  protected DiagnosticsEngine /*&*/ Diags;
  protected /*const*/ LangOptions /*&*/ LangOpts;
  protected ASTContext /*P*/ Context;
  protected SourceManager /*P*/ SM;
  protected TranslationUnitDecl /*P*/ TUDecl;
  protected FileID MainFileID;
  protected /*const*/char$ptr/*char P*/ MainFileStart;
  protected /*const*/char$ptr/*char P*/ MainFileEnd;
  protected Stmt /*P*/ CurrentBody;
  protected ParentMap /*P*/ PropParentMap; // created lazily.
  protected std.string InFileName;
  protected std.unique_ptr<raw_ostream> OutFile;
  protected std.string Preamble;
  
  protected TypeDecl /*P*/ ProtocolTypeDecl;
  protected VarDecl /*P*/ GlobalVarDecl;
  protected /*uint*/int RewriteFailedDiag;
  // ObjC string constant support.
  protected /*uint*/int NumObjCStringLiterals;
  protected VarDecl /*P*/ ConstantStringClassReference;
  protected RecordDecl /*P*/ NSStringRecord;
  
  // ObjC foreach break/continue generation support.
  protected int BcLabelCount;
  
  protected /*uint*/int TryFinallyContainsReturnDiag;
  // Needed for super.
  protected ObjCMethodDecl /*P*/ CurMethodDef;
  protected RecordDecl /*P*/ SuperStructDecl;
  protected RecordDecl /*P*/ ConstantStringDecl;
  
  protected FunctionDecl /*P*/ MsgSendFunctionDecl;
  protected FunctionDecl /*P*/ MsgSendSuperFunctionDecl;
  protected FunctionDecl /*P*/ MsgSendStretFunctionDecl;
  protected FunctionDecl /*P*/ MsgSendSuperStretFunctionDecl;
  protected FunctionDecl /*P*/ MsgSendFpretFunctionDecl;
  protected FunctionDecl /*P*/ GetClassFunctionDecl;
  protected FunctionDecl /*P*/ GetMetaClassFunctionDecl;
  protected FunctionDecl /*P*/ GetSuperClassFunctionDecl;
  protected FunctionDecl /*P*/ SelGetUidFunctionDecl;
  protected FunctionDecl /*P*/ CFStringFunctionDecl;
  protected FunctionDecl /*P*/ SuperConstructorFunctionDecl;
  protected FunctionDecl /*P*/ CurFunctionDef;
  protected FunctionDecl /*P*/ CurFunctionDeclToDeclareForBlock;
  
  /* Misc. containers needed for meta-data rewrite. */
  protected SmallVector<ObjCImplementationDecl /*P*/ > ClassImplementation;
  protected SmallVector<ObjCCategoryImplDecl /*P*/ > CategoryImplementation;
  protected SmallPtrSet<ObjCInterfaceDecl /*P*/ > ObjCSynthesizedStructs;
  protected SmallPtrSet<ObjCProtocolDecl /*P*/ > ObjCSynthesizedProtocols;
  protected SmallPtrSet<ObjCInterfaceDecl /*P*/ > ObjCForwardDecls;
  protected DenseMap<ObjCMethodDecl /*P*/ , std.string> MethodInternalNames;
  protected SmallVector<Stmt /*P*/ > Stmts;
  protected SmallVectorInt/*8*/ ObjCBcLabelNo;
  // Remember all the @protocol(<expr>) expressions.
  protected SmallPtrSet<ObjCProtocolDecl /*P*/ > ProtocolExprDecls;
  
  protected DenseSetULong CopyDestroyCache;
  
  // Block expressions.
  protected SmallVector<BlockExpr /*P*/ > Blocks;
  protected SmallVectorInt/*32*/ InnerDeclRefsCount;
  protected SmallVector<DeclRefExpr /*P*/ > InnerDeclRefs;
  
  protected SmallVector<DeclRefExpr /*P*/ > BlockDeclRefs;
  
  // Block related declarations.
  protected SmallVector<ValueDecl /*P*/ > BlockByCopyDecls;
  protected SmallPtrSet<ValueDecl /*P*/ > BlockByCopyDeclsPtrSet;
  protected SmallVector<ValueDecl /*P*/ > BlockByRefDecls;
  protected SmallPtrSet<ValueDecl /*P*/ > BlockByRefDeclsPtrSet;
  protected DenseMapTypeUInt<ValueDecl /*P*/ > BlockByRefDeclNo;
  protected SmallPtrSet<ValueDecl /*P*/ > ImportedBlockDecls;
  protected SmallPtrSet<VarDecl /*P*/ > ImportedLocalExternalDecls;
  
  protected DenseMap<BlockExpr /*P*/ , std.string> RewrittenBlockExprs;
  
  // This maps an original source AST to it's rewritten form. This allows
  // us to avoid rewriting the same node twice (which is very uncommon).
  // This is needed to support some of the exotic property rewriting.
  protected DenseMap<Stmt /*P*/ , Stmt /*P*/ > ReplacedNodes;
  
  // Needed for header files being rewritten
  protected boolean IsHeader;
  protected boolean SilenceRewriteMacroWarning;
  protected boolean objc_impl_method;
  
  protected boolean DisableReplaceStmt;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::DisableReplaceStmtScope">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 151,
   FQN="(anonymous namespace)::RewriteObjC::DisableReplaceStmtScope", NM="_ZN12_GLOBAL__N_111RewriteObjC23DisableReplaceStmtScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23DisableReplaceStmtScopeE")
  //</editor-fold>
  protected static class DisableReplaceStmtScope implements Destructors.ClassWithDestructor {
    private RewriteObjC /*&*/ R;
    private boolean SavedValue;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::DisableReplaceStmtScope::DisableReplaceStmtScope">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 156,
     FQN="(anonymous namespace)::RewriteObjC::DisableReplaceStmtScope::DisableReplaceStmtScope", NM="_ZN12_GLOBAL__N_111RewriteObjC23DisableReplaceStmtScopeC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23DisableReplaceStmtScopeC1ERS0_")
    //</editor-fold>
    public DisableReplaceStmtScope(RewriteObjC /*&*/ R) {
      // : R(R), SavedValue(R.DisableReplaceStmt) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::DisableReplaceStmtScope::~DisableReplaceStmtScope">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 161,
     FQN="(anonymous namespace)::RewriteObjC::DisableReplaceStmtScope::~DisableReplaceStmtScope", NM="_ZN12_GLOBAL__N_111RewriteObjC23DisableReplaceStmtScopeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23DisableReplaceStmtScopeD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "R=" + R // NOI18N
                + ", SavedValue=" + SavedValue; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::InitializeCommon">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 600,
   FQN="(anonymous namespace)::RewriteObjC::InitializeCommon", NM="_ZN12_GLOBAL__N_111RewriteObjC16InitializeCommonERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC16InitializeCommonERN5clang10ASTContextE")
  //</editor-fold>
  protected void InitializeCommon(ASTContext /*&*/ context) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  // Top Level Driver code.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 170,
   FQN="(anonymous namespace)::RewriteObjC::HandleTopLevelDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC18HandleTopLevelDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC18HandleTopLevelDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef D)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  //===----------------------------------------------------------------------===//
  // Top Level Driver Code
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::HandleTopLevelSingleDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 644,
   FQN="(anonymous namespace)::RewriteObjC::HandleTopLevelSingleDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC24HandleTopLevelSingleDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC24HandleTopLevelSingleDeclEPN5clang4DeclE")
  //</editor-fold>
  public void HandleTopLevelSingleDecl(Decl /*P*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// HandleDeclInMainFile - This is called for each top-level decl defined in the
  /// main file of the input.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::HandleDeclInMainFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4783,
   FQN="(anonymous namespace)::RewriteObjC::HandleDeclInMainFile", NM="_ZN12_GLOBAL__N_111RewriteObjC20HandleDeclInMainFileEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC20HandleDeclInMainFileEPN5clang4DeclE")
  //</editor-fold>
  public void HandleDeclInMainFile(Decl /*P*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 577,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjC", NM="_ZN12_GLOBAL__N_111RewriteObjCC1ESsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EERN5clang17DiagnosticsEngineERKNS7_11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjCC1ESsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EERN5clang17DiagnosticsEngineERKNS7_11LangOptionsEb")
  //</editor-fold>
  public RewriteObjC(std.string inFile, std.unique_ptr<raw_ostream> OS, 
      DiagnosticsEngine /*&*/ D, /*const*/ LangOptions /*&*/ LOpts, 
      boolean silenceMacroWarn) {
    // : ASTConsumer(), Rewrite(), Diags(D), LangOpts(LOpts), MainFileID(), InFileName(inFile), OutFile(std::move(OS)), Preamble(), ClassImplementation(), CategoryImplementation(), ObjCSynthesizedStructs(), ObjCSynthesizedProtocols(), ObjCForwardDecls(), MethodInternalNames(), Stmts(), ObjCBcLabelNo(), ProtocolExprDecls(), CopyDestroyCache(), Blocks(), InnerDeclRefsCount(), InnerDeclRefs(), BlockDeclRefs(), BlockByCopyDecls(), BlockByCopyDeclsPtrSet(), BlockByRefDecls(), BlockByRefDeclsPtrSet(), BlockByRefDeclNo(), ImportedBlockDecls(), ImportedLocalExternalDecls(), RewrittenBlockExprs(), ReplacedNodes(), SilenceRewriteMacroWarning(silenceMacroWarn) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::~RewriteObjC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 197,
   FQN="(anonymous namespace)::RewriteObjC::~RewriteObjC", NM="_ZN12_GLOBAL__N_111RewriteObjCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjCD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4906,
   FQN="(anonymous namespace)::RewriteObjC::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_111RewriteObjC21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(ASTContext /*&*/ C)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::ReplaceStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 201,
   FQN="(anonymous namespace)::RewriteObjC::ReplaceStmt", NM="_ZN12_GLOBAL__N_111RewriteObjC11ReplaceStmtEPN5clang4StmtES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC11ReplaceStmtEPN5clang4StmtES3_")
  //</editor-fold>
  public void ReplaceStmt(Stmt /*P*/ Old, Stmt /*P*/ New) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::ReplaceStmtWithRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 205,
   FQN="(anonymous namespace)::RewriteObjC::ReplaceStmtWithRange", NM="_ZN12_GLOBAL__N_111RewriteObjC20ReplaceStmtWithRangeEPN5clang4StmtES3_NS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC20ReplaceStmtWithRangeEPN5clang4StmtES3_NS1_11SourceRangeE")
  //</editor-fold>
  public void ReplaceStmtWithRange(Stmt /*P*/ Old, Stmt /*P*/ New, SourceRange SrcRange) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::InsertText">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 239,
   FQN="(anonymous namespace)::RewriteObjC::InsertText", NM="_ZN12_GLOBAL__N_111RewriteObjC10InsertTextEN5clang14SourceLocationEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC10InsertTextEN5clang14SourceLocationEN4llvm9StringRefEb")
  //</editor-fold>
  public void InsertText(SourceLocation Loc, StringRef Str) {
    InsertText(Loc, Str, 
            true);
  }
  public void InsertText(SourceLocation Loc, StringRef Str, 
            boolean InsertAfter/*= true*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::ReplaceText">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 249,
   FQN="(anonymous namespace)::RewriteObjC::ReplaceText", NM="_ZN12_GLOBAL__N_111RewriteObjC11ReplaceTextEN5clang14SourceLocationEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC11ReplaceTextEN5clang14SourceLocationEjN4llvm9StringRefE")
  //</editor-fold>
  public void ReplaceText(SourceLocation Start, /*uint*/int OrigLength, 
             StringRef Str) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Syntactic Rewriting.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteRecordBody">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4771,
   FQN="(anonymous namespace)::RewriteObjC::RewriteRecordBody", NM="_ZN12_GLOBAL__N_111RewriteObjC17RewriteRecordBodyEPN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC17RewriteRecordBodyEPN5clang10RecordDeclE")
  //</editor-fold>
  public void RewriteRecordBody(RecordDecl /*P*/ RD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===----------------------------------------------------------------------===//
  // Syntactic (non-AST) Rewriting Code
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteInclude">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 730,
   FQN="(anonymous namespace)::RewriteObjC::RewriteInclude", NM="_ZN12_GLOBAL__N_111RewriteObjC14RewriteIncludeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC14RewriteIncludeEv")
  //</editor-fold>
  public void RewriteInclude() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteForwardClassDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 910,
   FQN="(anonymous namespace)::RewriteObjC::RewriteForwardClassDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC23RewriteForwardClassDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23RewriteForwardClassDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  public void RewriteForwardClassDecl(DeclGroupRef D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteForwardClassDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 928,
   FQN="(anonymous namespace)::RewriteObjC::RewriteForwardClassDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC23RewriteForwardClassDeclERKN4llvm15SmallVectorImplIPN5clang4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23RewriteForwardClassDeclERKN4llvm15SmallVectorImplIPN5clang4DeclEEE")
  //</editor-fold>
  public void RewriteForwardClassDecl(/*const*/ SmallVectorImpl<Decl /*P*/ > /*&*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteForwardClassEpilogue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 901,
   FQN="(anonymous namespace)::RewriteObjC::RewriteForwardClassEpilogue", NM="_ZN12_GLOBAL__N_111RewriteObjC27RewriteForwardClassEpilogueEPN5clang17ObjCInterfaceDeclERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC27RewriteForwardClassEpilogueEPN5clang17ObjCInterfaceDeclERKSs")
  //</editor-fold>
  public void RewriteForwardClassEpilogue(ObjCInterfaceDecl /*P*/ ClassDecl, 
                             /*const*/std.string/*&*/ typedefString) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===----------------------------------------------------------------------===//
  // Meta Data Emission
  //===----------------------------------------------------------------------===//
  
  /// RewriteImplementations - This routine rewrites all method implementations
  /// and emits meta-data.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteImplementations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3222,
   FQN="(anonymous namespace)::RewriteObjC::RewriteImplementations", NM="_ZN12_GLOBAL__N_111RewriteObjC22RewriteImplementationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC22RewriteImplementationsEv")
  //</editor-fold>
  public void RewriteImplementations() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewritePropertyImplDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 766,
   FQN="(anonymous namespace)::RewriteObjC::RewritePropertyImplDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC23RewritePropertyImplDeclEPN5clang20ObjCPropertyImplDeclEPNS1_22ObjCImplementationDeclEPNS1_20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23RewritePropertyImplDeclEPN5clang20ObjCPropertyImplDeclEPNS1_22ObjCImplementationDeclEPNS1_20ObjCCategoryImplDeclE")
  //</editor-fold>
  public void RewritePropertyImplDecl(ObjCPropertyImplDecl /*P*/ PID, 
                         ObjCImplementationDecl /*P*/ IMD, 
                         ObjCCategoryImplDecl /*P*/ CID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1196,
   FQN="(anonymous namespace)::RewriteObjC::RewriteInterfaceDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC20RewriteInterfaceDeclEPN5clang17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC20RewriteInterfaceDeclEPN5clang17ObjCInterfaceDeclE")
  //</editor-fold>
  public void RewriteInterfaceDecl(ObjCInterfaceDecl /*P*/ ClassDecl) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteImplementationDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1163,
   FQN="(anonymous namespace)::RewriteObjC::RewriteImplementationDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC25RewriteImplementationDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC25RewriteImplementationDeclEPN5clang4DeclE")
  //</editor-fold>
  public void RewriteImplementationDecl(Decl /*P*/ OID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1059,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCMethodDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC21RewriteObjCMethodDeclEPKN5clang17ObjCInterfaceDeclEPNS1_14ObjCMethodDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC21RewriteObjCMethodDeclEPKN5clang17ObjCInterfaceDeclEPNS1_14ObjCMethodDeclERSs")
  //</editor-fold>
  public void RewriteObjCMethodDecl(/*const*/ ObjCInterfaceDecl /*P*/ IDecl, 
                       ObjCMethodDecl /*P*/ OMD, 
                       std.string/*&*/ ResultStr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteTypeIntoString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1036,
   FQN="(anonymous namespace)::RewriteObjC::RewriteTypeIntoString", NM="_ZN12_GLOBAL__N_111RewriteObjC21RewriteTypeIntoStringEN5clang8QualTypeERSsRPKNS1_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC21RewriteTypeIntoStringEN5clang8QualTypeERSsRPKNS1_12FunctionTypeE")
  //</editor-fold>
  public void RewriteTypeIntoString(QualType T, std.string/*&*/ ResultStr, 
                       /*const*/ FunctionType /*P*/ /*&*/ FPRetType) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteByRefString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3234,
   FQN="(anonymous namespace)::RewriteObjC::RewriteByRefString", NM="_ZN12_GLOBAL__N_111RewriteObjC18RewriteByRefStringERSsRKSsPN5clang9ValueDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC18RewriteByRefStringERSsRKSsPN5clang9ValueDeclEb")
  //</editor-fold>
  public void RewriteByRefString(std.string/*&*/ ResultStr, 
                    /*const*/std.string/*&*/ Name, 
                    ValueDecl /*P*/ VD) {
    RewriteByRefString(ResultStr, 
                    Name, 
                    VD, false);
  }
  public void RewriteByRefString(std.string/*&*/ ResultStr, 
                    /*const*/std.string/*&*/ Name, 
                    ValueDecl /*P*/ VD, boolean def/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 966,
   FQN="(anonymous namespace)::RewriteObjC::RewriteCategoryDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC19RewriteCategoryDeclEPN5clang16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC19RewriteCategoryDeclEPN5clang16ObjCCategoryDeclE")
  //</editor-fold>
  public void RewriteCategoryDecl(ObjCCategoryDecl /*P*/ CatDecl) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 984,
   FQN="(anonymous namespace)::RewriteObjC::RewriteProtocolDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC19RewriteProtocolDeclEPN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC19RewriteProtocolDeclEPN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  public void RewriteProtocolDecl(ObjCProtocolDecl /*P*/ PDecl) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteForwardProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1019,
   FQN="(anonymous namespace)::RewriteObjC::RewriteForwardProtocolDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC26RewriteForwardProtocolDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC26RewriteForwardProtocolDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  public void RewriteForwardProtocolDecl(DeclGroupRef D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteForwardProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1027,
   FQN="(anonymous namespace)::RewriteObjC::RewriteForwardProtocolDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC26RewriteForwardProtocolDeclERKN4llvm15SmallVectorImplIPN5clang4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC26RewriteForwardProtocolDeclERKN4llvm15SmallVectorImplIPN5clang4DeclEEE")
  //</editor-fold>
  public void RewriteForwardProtocolDecl(/*const*/ SmallVectorImpl<Decl /*P*/ > /*&*/ DG) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteMethodDeclaration">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 942,
   FQN="(anonymous namespace)::RewriteObjC::RewriteMethodDeclaration", NM="_ZN12_GLOBAL__N_111RewriteObjC24RewriteMethodDeclarationEPN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC24RewriteMethodDeclarationEPN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public void RewriteMethodDeclaration(ObjCMethodDecl /*P*/ Method) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteProperty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 959,
   FQN="(anonymous namespace)::RewriteObjC::RewriteProperty", NM="_ZN12_GLOBAL__N_111RewriteObjC15RewritePropertyEPN5clang16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC15RewritePropertyEPN5clang16ObjCPropertyDeclE")
  //</editor-fold>
  public void RewriteProperty(ObjCPropertyDecl /*P*/ prop) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2233,
   FQN="(anonymous namespace)::RewriteObjC::RewriteFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC19RewriteFunctionDeclEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC19RewriteFunctionDeclEPN5clang12FunctionDeclE")
  //</editor-fold>
  public void RewriteFunctionDecl(FunctionDecl /*P*/ FD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2243,
   FQN="(anonymous namespace)::RewriteObjC::RewriteBlockPointerType", NM="_ZN12_GLOBAL__N_111RewriteObjC23RewriteBlockPointerTypeERSsN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23RewriteBlockPointerTypeERSsN5clang8QualTypeE")
  //</editor-fold>
  public void RewriteBlockPointerType(std.string/*&*/ Str, QualType Type) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // FIXME. Consolidate this routine with RewriteBlockPointerType.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteBlockPointerTypeVariable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2257,
   FQN="(anonymous namespace)::RewriteObjC::RewriteBlockPointerTypeVariable", NM="_ZN12_GLOBAL__N_111RewriteObjC31RewriteBlockPointerTypeVariableERSsPN5clang9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC31RewriteBlockPointerTypeVariableERSsPN5clang9ValueDeclE")
  //</editor-fold>
  public void RewriteBlockPointerTypeVariable(std.string/*&*/ Str, 
                                 ValueDecl /*P*/ VD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteBlockLiteralFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2286,
   FQN="(anonymous namespace)::RewriteObjC::RewriteBlockLiteralFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC31RewriteBlockLiteralFunctionDeclEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC31RewriteBlockLiteralFunctionDeclEPN5clang12FunctionDeclE")
  //</editor-fold>
  public void RewriteBlockLiteralFunctionDecl(FunctionDecl /*P*/ FD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCQualifiedInterfaceTypes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2105,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCQualifiedInterfaceTypes", NM="_ZN12_GLOBAL__N_111RewriteObjC34RewriteObjCQualifiedInterfaceTypesEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC34RewriteObjCQualifiedInterfaceTypesEPN5clang4DeclE")
  //</editor-fold>
  public void RewriteObjCQualifiedInterfaceTypes(Decl /*P*/ Dcl) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteTypeOfDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2183,
   FQN="(anonymous namespace)::RewriteObjC::RewriteTypeOfDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC17RewriteTypeOfDeclEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC17RewriteTypeOfDeclEPN5clang7VarDeclE")
  //</editor-fold>
  public void RewriteTypeOfDecl(VarDecl /*P*/ ND) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCQualifiedInterfaceTypes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2075,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCQualifiedInterfaceTypes", NM="_ZN12_GLOBAL__N_111RewriteObjC34RewriteObjCQualifiedInterfaceTypesEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC34RewriteObjCQualifiedInterfaceTypesEPN5clang4ExprE")
  //</editor-fold>
  public void RewriteObjCQualifiedInterfaceTypes(Expr /*P*/ E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Expression Rewriting.
  
  //===----------------------------------------------------------------------===//
  // Function Body / Expression rewriting
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteFunctionBodyOrGlobalInitializer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4556,
   FQN="(anonymous namespace)::RewriteObjC::RewriteFunctionBodyOrGlobalInitializer", NM="_ZN12_GLOBAL__N_111RewriteObjC38RewriteFunctionBodyOrGlobalInitializerEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC38RewriteFunctionBodyOrGlobalInitializerEPN5clang4StmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteFunctionBodyOrGlobalInitializer(Stmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteAtEncode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1976,
   FQN="(anonymous namespace)::RewriteObjC::RewriteAtEncode", NM="_ZN12_GLOBAL__N_111RewriteObjC15RewriteAtEncodeEPN5clang14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC15RewriteAtEncodeEPN5clang14ObjCEncodeExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteAtEncode(ObjCEncodeExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewritePropertyOrImplicitGetter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1309,
   FQN="(anonymous namespace)::RewriteObjC::RewritePropertyOrImplicitGetter", NM="_ZN12_GLOBAL__N_111RewriteObjC31RewritePropertyOrImplicitGetterEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC31RewritePropertyOrImplicitGetterEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public Stmt /*P*/ RewritePropertyOrImplicitGetter(PseudoObjectExpr /*P*/ PseudoOp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewritePropertyOrImplicitSetter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1226,
   FQN="(anonymous namespace)::RewriteObjC::RewritePropertyOrImplicitSetter", NM="_ZN12_GLOBAL__N_111RewriteObjC31RewritePropertyOrImplicitSetterEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC31RewritePropertyOrImplicitSetterEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public Stmt /*P*/ RewritePropertyOrImplicitSetter(PseudoObjectExpr /*P*/ PseudoOp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteAtSelector">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1988,
   FQN="(anonymous namespace)::RewriteObjC::RewriteAtSelector", NM="_ZN12_GLOBAL__N_111RewriteObjC17RewriteAtSelectorEPN5clang16ObjCSelectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC17RewriteAtSelectorEPN5clang16ObjCSelectorExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteAtSelector(ObjCSelectorExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteMessageExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3009,
   FQN="(anonymous namespace)::RewriteObjC::RewriteMessageExpr", NM="_ZN12_GLOBAL__N_111RewriteObjC18RewriteMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC18RewriteMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteMessageExpr(ObjCMessageExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2476,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCStringLiteral", NM="_ZN12_GLOBAL__N_111RewriteObjC24RewriteObjCStringLiteralEPN5clang17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC24RewriteObjCStringLiteralEPN5clang17ObjCStringLiteralE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCStringLiteral(ObjCStringLiteral /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteObjCProtocolExpr - Rewrite a protocol expression into
  /// a synthesized/forward data reference (to the protocol's metadata).
  /// The forward references (and metadata) are generated in
  /// RewriteObjC::HandleTranslationUnit().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3037,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCProtocolExpr", NM="_ZN12_GLOBAL__N_111RewriteObjC23RewriteObjCProtocolExprEPN5clang16ObjCProtocolExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23RewriteObjCProtocolExprEPN5clang16ObjCProtocolExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCProtocolExpr(ObjCProtocolExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteTryReturnStmts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1737,
   FQN="(anonymous namespace)::RewriteObjC::RewriteTryReturnStmts", NM="_ZN12_GLOBAL__N_111RewriteObjC21RewriteTryReturnStmtsEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC21RewriteTryReturnStmtsEPN5clang4StmtE")
  //</editor-fold>
  public void RewriteTryReturnStmts(Stmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteSyncReturnStmts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1758,
   FQN="(anonymous namespace)::RewriteObjC::RewriteSyncReturnStmts", NM="_ZN12_GLOBAL__N_111RewriteObjC22RewriteSyncReturnStmtsEPN5clang4StmtESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC22RewriteSyncReturnStmtsEPN5clang4StmtESs")
  //</editor-fold>
  public void RewriteSyncReturnStmts(Stmt /*P*/ S, std.string syncExitBuf) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCTryStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1782,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCTryStmt", NM="_ZN12_GLOBAL__N_111RewriteObjC18RewriteObjCTryStmtEPN5clang13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC18RewriteObjCTryStmtEPN5clang13ObjCAtTryStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCTryStmt(ObjCAtTryStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteObjCSynchronizedStmt -
  /// This routine rewrites @synchronized(expr) stmt;
  /// into:
  /// objc_sync_enter(expr);
  /// @try stmt @finally { objc_sync_exit(expr); }
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1641,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCSynchronizedStmt", NM="_ZN12_GLOBAL__N_111RewriteObjC27RewriteObjCSynchronizedStmtEPN5clang22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC27RewriteObjCSynchronizedStmtEPN5clang22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCSynchronizedStmt(ObjCAtSynchronizedStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // This can't be done with ReplaceStmt(S, ThrowExpr), since
  // the throw expression is typically a message expression that's already
  // been rewritten! (which implies the SourceLocation's are invalid).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCThrowStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1950,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCThrowStmt", NM="_ZN12_GLOBAL__N_111RewriteObjC20RewriteObjCThrowStmtEPN5clang15ObjCAtThrowStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC20RewriteObjCThrowStmtEPN5clang15ObjCAtThrowStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCThrowStmt(ObjCAtThrowStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteObjCForCollectionStmt - Rewriter for ObjC2's foreach statement.
  ///  It rewrites:
  /// for ( type elem in collection) { stmts; }
  
  /// Into:
  /// {
  ///   type elem;
  ///   struct __objcFastEnumerationState enumState = { 0 };
  ///   id __rw_items[16];
  ///   id l_collection = (id)collection;
  ///   unsigned long limit = [l_collection countByEnumeratingWithState:&enumState
  ///                                       objects:__rw_items count:16];
  /// if (limit) {
  ///   unsigned long startMutations = *enumState.mutationsPtr;
  ///   do {
  ///        unsigned long counter = 0;
  ///        do {
  ///             if (startMutations != *enumState.mutationsPtr)
  ///               objc_enumerationMutation(l_collection);
  ///             elem = (type)enumState.itemsPtr[counter++];
  ///             stmts;
  ///             __continue_label: ;
  ///        } while (counter < limit);
  ///   } while (limit = [l_collection countByEnumeratingWithState:&enumState
  ///                                  objects:__rw_items count:16]);
  ///   elem = nil;
  ///   __break_label: ;
  ///  }
  ///  else
  ///       elem = nil;
  ///  }
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1471,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCForCollectionStmt", NM="_ZN12_GLOBAL__N_111RewriteObjC28RewriteObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC28RewriteObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtENS1_14SourceLocationE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ S, 
                              SourceLocation OrigEnd) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteBreakStmt - Rewrite for a break-stmt inside an ObjC2's foreach
  /// statement to exit to its outer synthesized loop.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteBreakStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1408,
   FQN="(anonymous namespace)::RewriteObjC::RewriteBreakStmt", NM="_ZN12_GLOBAL__N_111RewriteObjC16RewriteBreakStmtEPN5clang9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC16RewriteBreakStmtEPN5clang9BreakStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteBreakStmt(BreakStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteContinueStmt - Rewrite for a continue-stmt inside an ObjC2's foreach
  /// statement to continue with its inner synthesized loop.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteContinueStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1425,
   FQN="(anonymous namespace)::RewriteObjC::RewriteContinueStmt", NM="_ZN12_GLOBAL__N_111RewriteObjC19RewriteContinueStmtEPN5clang12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC19RewriteContinueStmtEPN5clang12ContinueStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteContinueStmt(ContinueStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteCastExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3885,
   FQN="(anonymous namespace)::RewriteObjC::RewriteCastExpr", NM="_ZN12_GLOBAL__N_111RewriteObjC15RewriteCastExprEPN5clang14CStyleCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC15RewriteCastExprEPN5clang14CStyleCastExprE")
  //</editor-fold>
  public void RewriteCastExpr(CStyleCastExpr /*P*/ CE) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Block rewriting.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteBlocksInFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 544,
   FQN="(anonymous namespace)::RewriteObjC::RewriteBlocksInFunctionProtoType", NM="_ZN12_GLOBAL__N_111RewriteObjC32RewriteBlocksInFunctionProtoTypeEN5clang8QualTypeEPNS1_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC32RewriteBlocksInFunctionProtoTypeEN5clang8QualTypeEPNS1_9NamedDeclE")
  //</editor-fold>
  public void RewriteBlocksInFunctionProtoType(QualType funcType, 
                                  NamedDecl /*P*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Block specific rewrite rules.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteBlockPointerDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4019,
   FQN="(anonymous namespace)::RewriteObjC::RewriteBlockPointerDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC23RewriteBlockPointerDeclEPN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23RewriteBlockPointerDeclEPN5clang9NamedDeclE")
  //</editor-fold>
  public void RewriteBlockPointerDecl(NamedDecl /*P*/ ND) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteByRefVar - For each __block typex ND variable this routine transforms
  /// the declaration into:
  /// struct __Block_byref_ND {
  /// void *__isa;                  // NULL for everything except __weak pointers
  /// struct __Block_byref_ND *__forwarding;
  /// int32_t __flags;
  /// int32_t __size;
  /// void *__Block_byref_id_object_copy; // If variable is __block ObjC object
  /// void *__Block_byref_id_object_dispose; // If variable is __block ObjC object
  /// typex ND;
  /// };
  ///
  /// It then replaces declaration of ND variable with:
  /// struct __Block_byref_ND ND = {__isa=0B, __forwarding=&ND, __flags=some_flag, 
  ///                               __size=sizeof(struct __Block_byref_ND), 
  ///                               ND=initializer-if-any};
  ///
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteByRefVar">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4168,
   FQN="(anonymous namespace)::RewriteObjC::RewriteByRefVar", NM="_ZN12_GLOBAL__N_111RewriteObjC15RewriteByRefVarEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC15RewriteByRefVarEPN5clang7VarDeclE")
  //</editor-fold>
  public void RewriteByRefVar(VarDecl /*P*/ ND) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // We need to return the rewritten expression to handle cases where the
  // BlockDeclRefExpr is embedded in another expression being rewritten.
  // For example:
  //
  // int main() {
  //    __block Foo *f;
  //    __block int i;
  //
  //    void (^myblock)() = ^() {
  //        [f test]; // f is a BlockDeclRefExpr embedded in a message (which is being rewritten).
  //        i = 77;
  //    };
  //}
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteBlockDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3832,
   FQN="(anonymous namespace)::RewriteObjC::RewriteBlockDeclRefExpr", NM="_ZN12_GLOBAL__N_111RewriteObjC23RewriteBlockDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23RewriteBlockDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteBlockDeclRefExpr(DeclRefExpr /*P*/ DeclRefExp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Rewrites the imported local variable V with external storage 
  // (static, extern, etc.) as *V
  //
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteLocalVariableExternalStorage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3870,
   FQN="(anonymous namespace)::RewriteObjC::RewriteLocalVariableExternalStorage", NM="_ZN12_GLOBAL__N_111RewriteObjC35RewriteLocalVariableExternalStorageEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC35RewriteLocalVariableExternalStorageEPN5clang11DeclRefExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteLocalVariableExternalStorage(DeclRefExpr /*P*/ DRE) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteBlockPointerFunctionArgs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3923,
   FQN="(anonymous namespace)::RewriteObjC::RewriteBlockPointerFunctionArgs", NM="_ZN12_GLOBAL__N_111RewriteObjC31RewriteBlockPointerFunctionArgsEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC31RewriteBlockPointerFunctionArgsEPN5clang12FunctionDeclE")
  //</editor-fold>
  public void RewriteBlockPointerFunctionArgs(FunctionDecl /*P*/ FD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// RewriteObjCInternalStruct - Rewrite one internal struct corresponding to
  /// an objective-c class with ivars.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCInternalStruct">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3085,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCInternalStruct", NM="_ZN12_GLOBAL__N_111RewriteObjC25RewriteObjCInternalStructEPN5clang17ObjCInterfaceDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC25RewriteObjCInternalStructEPN5clang17ObjCInterfaceDeclERSs")
  //</editor-fold>
  public void RewriteObjCInternalStruct(ObjCInterfaceDecl /*P*/ CDecl, 
                           std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::Initialize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 325,
   FQN="(anonymous namespace)::RewriteObjC::Initialize", NM="_ZN12_GLOBAL__N_111RewriteObjC10InitializeERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC10InitializeERN5clang10ASTContextE")
  //</editor-fold>
  @Override public abstract void Initialize(ASTContext /*&*/ context)/* override*//* = 0*/;

  
  // Metadata Rewriting.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteMetaDataIntoBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 328,
   FQN="(anonymous namespace)::RewriteObjC::RewriteMetaDataIntoBuffer", NM="_ZN12_GLOBAL__N_111RewriteObjC25RewriteMetaDataIntoBufferERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC25RewriteMetaDataIntoBufferERSs")
  //</editor-fold>
  public abstract /*virtual*/ void RewriteMetaDataIntoBuffer(std.string/*&*/ Result)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCProtocolListMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 329,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCProtocolListMetaData", NM="_ZN12_GLOBAL__N_111RewriteObjC31RewriteObjCProtocolListMetaDataERKN5clang8ObjCListINS1_16ObjCProtocolDeclEEEN4llvm9StringRefES8_RSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC31RewriteObjCProtocolListMetaDataERKN5clang8ObjCListINS1_16ObjCProtocolDeclEEEN4llvm9StringRefES8_RSs")
  //</editor-fold>
  public abstract /*virtual*/ void RewriteObjCProtocolListMetaData(/*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Prots, 
                                 StringRef prefix, 
                                 StringRef ClassName, 
                                 std.string/*&*/ Result)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 333,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCCategoryImplDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC27RewriteObjCCategoryImplDeclEPN5clang20ObjCCategoryImplDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC27RewriteObjCCategoryImplDeclEPN5clang20ObjCCategoryImplDeclERSs")
  //</editor-fold>
  public abstract /*virtual*/ void RewriteObjCCategoryImplDecl(ObjCCategoryImplDecl /*P*/ CDecl, 
                             std.string/*&*/ Result)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCProtocolMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 335,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCProtocolMetaData", NM="_ZN12_GLOBAL__N_111RewriteObjC27RewriteObjCProtocolMetaDataEPN5clang16ObjCProtocolDeclEN4llvm9StringRefES5_RSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC27RewriteObjCProtocolMetaDataEPN5clang16ObjCProtocolDeclEN4llvm9StringRefES5_RSs")
  //</editor-fold>
  public abstract /*virtual*/ void RewriteObjCProtocolMetaData(ObjCProtocolDecl /*P*/ Protocol, 
                             StringRef prefix, 
                             StringRef ClassName, 
                             std.string/*&*/ Result)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCClassMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 339,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCClassMetaData", NM="_ZN12_GLOBAL__N_111RewriteObjC24RewriteObjCClassMetaDataEPN5clang22ObjCImplementationDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC24RewriteObjCClassMetaDataEPN5clang22ObjCImplementationDeclERSs")
  //</editor-fold>
  public abstract /*virtual*/ void RewriteObjCClassMetaData(ObjCImplementationDecl /*P*/ IDecl, 
                          std.string/*&*/ Result)/* = 0*/;

  
  // Rewriting ivar access
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 343,
   FQN="(anonymous namespace)::RewriteObjC::RewriteObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_111RewriteObjC22RewriteObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC22RewriteObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public abstract /*virtual*/ Stmt /*P*/ RewriteObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ IV)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::RewriteIvarOffsetComputation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 344,
   FQN="(anonymous namespace)::RewriteObjC::RewriteIvarOffsetComputation", NM="_ZN12_GLOBAL__N_111RewriteObjC28RewriteIvarOffsetComputationEPN5clang12ObjCIvarDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC28RewriteIvarOffsetComputationEPN5clang12ObjCIvarDeclERSs")
  //</editor-fold>
  public abstract /*virtual*/ void RewriteIvarOffsetComputation(ObjCIvarDecl /*P*/ ivar, 
                              std.string/*&*/ Result)/* = 0*/;

  
  // Misc. AST transformation routines. Sometimes they end up calling
  // rewriting routines on the new ASTs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthesizeCallToFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2002,
   FQN="(anonymous namespace)::RewriteObjC::SynthesizeCallToFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC28SynthesizeCallToFunctionDeclEPN5clang12FunctionDeclEN4llvm8ArrayRefIPNS1_4ExprEEENS1_14SourceLocationES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC28SynthesizeCallToFunctionDeclEPN5clang12FunctionDeclEN4llvm8ArrayRefIPNS1_4ExprEEENS1_14SourceLocationES9_")
  //</editor-fold>
  public CallExpr /*P*/ SynthesizeCallToFunctionDecl(FunctionDecl /*P*/ FD, 
                              ArrayRef<Expr /*P*/ > Args) {
    return SynthesizeCallToFunctionDecl(FD, 
                              Args, 
                              new SourceLocation(), 
                              new SourceLocation());
  }
  public CallExpr /*P*/ SynthesizeCallToFunctionDecl(FunctionDecl /*P*/ FD, 
                              ArrayRef<Expr /*P*/ > Args, 
                              SourceLocation StartLoc/*= SourceLocation()*/) {
    return SynthesizeCallToFunctionDecl(FD, 
                              Args, 
                              StartLoc, 
                              new SourceLocation());
  }
  public CallExpr /*P*/ SynthesizeCallToFunctionDecl(FunctionDecl /*P*/ FD, 
                              ArrayRef<Expr /*P*/ > Args, 
                              SourceLocation StartLoc/*= SourceLocation()*/, 
                              SourceLocation EndLoc/*= SourceLocation()*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthMsgSendStretCallExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2584,
   FQN="(anonymous namespace)::RewriteObjC::SynthMsgSendStretCallExpr", NM="_ZN12_GLOBAL__N_111RewriteObjC25SynthMsgSendStretCallExprEPN5clang12FunctionDeclENS1_8QualTypeES4_RN4llvm15SmallVectorImplIS4_EERNS6_IPNS1_4ExprEEEPNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC25SynthMsgSendStretCallExprEPN5clang12FunctionDeclENS1_8QualTypeES4_RN4llvm15SmallVectorImplIS4_EERNS6_IPNS1_4ExprEEEPNS1_14ObjCMethodDeclE")
  //</editor-fold>
  public CallExpr /*P*/ SynthMsgSendStretCallExpr(FunctionDecl /*P*/ MsgSendStretFlavor, 
                           QualType msgSendType, 
                           QualType returnType, 
                           SmallVectorImpl<QualType> /*&*/ ArgTypes, 
                           SmallVectorImpl<Expr /*P*/ > /*&*/ MsgExprs, 
                           ObjCMethodDecl /*P*/ Method) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthMessageExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2615,
   FQN="(anonymous namespace)::RewriteObjC::SynthMessageExpr", NM="_ZN12_GLOBAL__N_111RewriteObjC16SynthMessageExprEPN5clang15ObjCMessageExprENS1_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC16SynthMessageExprEPN5clang15ObjCMessageExprENS1_14SourceLocationES4_")
  //</editor-fold>
  public Stmt /*P*/ SynthMessageExpr(ObjCMessageExpr /*P*/ Exp) {
    return SynthMessageExpr(Exp, 
                  new SourceLocation(), 
                  new SourceLocation());
  }
  public Stmt /*P*/ SynthMessageExpr(ObjCMessageExpr /*P*/ Exp, 
                  SourceLocation StartLoc/*= SourceLocation()*/) {
    return SynthMessageExpr(Exp, 
                  StartLoc, 
                  new SourceLocation());
  }
  public Stmt /*P*/ SynthMessageExpr(ObjCMessageExpr /*P*/ Exp, 
                  SourceLocation StartLoc/*= SourceLocation()*/, 
                  SourceLocation EndLoc/*= SourceLocation()*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// SynthCountByEnumWithState - To print:
  /// ((unsigned int (*)
  ///  (id, SEL, struct __objcFastEnumerationState *, id *, unsigned int))
  ///  (void *)objc_msgSend)((id)l_collection,
  ///                        sel_registerName(
  ///                          "countByEnumeratingWithState:objects:count:"),
  ///                        &enumState,
  ///                        (id *)__rw_items, (unsigned int)16)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthCountByEnumWithState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1394,
   FQN="(anonymous namespace)::RewriteObjC::SynthCountByEnumWithState", NM="_ZN12_GLOBAL__N_111RewriteObjC25SynthCountByEnumWithStateERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC25SynthCountByEnumWithStateERSs")
  //</editor-fold>
  public void SynthCountByEnumWithState(std.string/*&*/ buf) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendFunctionDecl - id objc_msgSend(id self, SEL op, ...);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthMsgSendFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2329,
   FQN="(anonymous namespace)::RewriteObjC::SynthMsgSendFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC24SynthMsgSendFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC24SynthMsgSendFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendSuperFunctionDecl - id objc_msgSendSuper(struct objc_super *, SEL op, ...);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthMsgSendSuperFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2348,
   FQN="(anonymous namespace)::RewriteObjC::SynthMsgSendSuperFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC29SynthMsgSendSuperFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC29SynthMsgSendSuperFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendSuperFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendStretFunctionDecl - id objc_msgSend_stret(id self, SEL op, ...);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthMsgSendStretFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2370,
   FQN="(anonymous namespace)::RewriteObjC::SynthMsgSendStretFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC29SynthMsgSendStretFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC29SynthMsgSendStretFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendStretFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendFpretFunctionDecl - double objc_msgSend_fpret(id self, SEL op, ...);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthMsgSendFpretFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2414,
   FQN="(anonymous namespace)::RewriteObjC::SynthMsgSendFpretFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC29SynthMsgSendFpretFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC29SynthMsgSendFpretFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendFpretFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendSuperStretFunctionDecl -
  // id objc_msgSendSuper_stret(struct objc_super *, SEL op, ...);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthMsgSendSuperStretFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2390,
   FQN="(anonymous namespace)::RewriteObjC::SynthMsgSendSuperStretFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC34SynthMsgSendSuperStretFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC34SynthMsgSendSuperStretFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendSuperStretFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthGetClassFunctionDecl - id objc_getClass(const char *name);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthGetClassFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2433,
   FQN="(anonymous namespace)::RewriteObjC::SynthGetClassFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC25SynthGetClassFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC25SynthGetClassFunctionDeclEv")
  //</editor-fold>
  public void SynthGetClassFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthGetMetaClassFunctionDecl - id objc_getMetaClass(const char *name);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthGetMetaClassFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2463,
   FQN="(anonymous namespace)::RewriteObjC::SynthGetMetaClassFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC29SynthGetMetaClassFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC29SynthGetMetaClassFunctionDeclEv")
  //</editor-fold>
  public void SynthGetMetaClassFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthGetSuperClassFunctionDecl - Class class_getSuperclass(Class cls);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthGetSuperClassFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2447,
   FQN="(anonymous namespace)::RewriteObjC::SynthGetSuperClassFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC30SynthGetSuperClassFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC30SynthGetSuperClassFunctionDeclEv")
  //</editor-fold>
  public void SynthGetSuperClassFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthSelGetUidFunctionDecl - SEL sel_registerName(const char *str);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthSelGetUidFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2220,
   FQN="(anonymous namespace)::RewriteObjC::SynthSelGetUidFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC26SynthSelGetUidFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC26SynthSelGetUidFunctionDeclEv")
  //</editor-fold>
  public void SynthSelGetUidFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthSuperConstructorFunctionDecl - id objc_super(id obj, id super);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthSuperConstructorFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2310,
   FQN="(anonymous namespace)::RewriteObjC::SynthSuperConstructorFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC33SynthSuperConstructorFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC33SynthSuperConstructorFunctionDeclEv")
  //</editor-fold>
  public void SynthSuperConstructorFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// SynthesizeByrefCopyDestroyHelper - This routine synthesizes:
  /// void __Block_byref_id_object_copy(struct Block_byref_id_object *dst,
  ///                    struct Block_byref_id_object *src) {
  ///  _Block_object_assign (&_dest->object, _src->object, 
  ///                        BLOCK_BYREF_CALLER | BLOCK_FIELD_IS_OBJECT
  ///                        [|BLOCK_FIELD_IS_WEAK]) // object
  ///  _Block_object_assign(&_dest->object, _src->object, 
  ///                       BLOCK_BYREF_CALLER | BLOCK_FIELD_IS_BLOCK
  ///                       [|BLOCK_FIELD_IS_WEAK]) // block
  /// }
  /// And:
  /// void __Block_byref_id_object_dispose(struct Block_byref_id_object *_src) {
  ///  _Block_object_dispose(_src->object, 
  ///                        BLOCK_BYREF_CALLER | BLOCK_FIELD_IS_OBJECT
  ///                        [|BLOCK_FIELD_IS_WEAK]) // object
  ///  _Block_object_dispose(_src->object, 
  ///                         BLOCK_BYREF_CALLER | BLOCK_FIELD_IS_BLOCK
  ///                         [|BLOCK_FIELD_IS_WEAK]) // block
  /// }
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthesizeByrefCopyDestroyHelper">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4113,
   FQN="(anonymous namespace)::RewriteObjC::SynthesizeByrefCopyDestroyHelper", NM="_ZN12_GLOBAL__N_111RewriteObjC32SynthesizeByrefCopyDestroyHelperEPN5clang7VarDeclEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC32SynthesizeByrefCopyDestroyHelperEPN5clang7VarDeclEi")
  //</editor-fold>
  public std.string SynthesizeByrefCopyDestroyHelper(VarDecl /*P*/ VD, 
                                  int flag) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthesizeBlockHelperFuncs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3343,
   FQN="(anonymous namespace)::RewriteObjC::SynthesizeBlockHelperFuncs", NM="_ZN12_GLOBAL__N_111RewriteObjC26SynthesizeBlockHelperFuncsEPN5clang9BlockExprEiN4llvm9StringRefESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC26SynthesizeBlockHelperFuncsEPN5clang9BlockExprEiN4llvm9StringRefESs")
  //</editor-fold>
  public std.string SynthesizeBlockHelperFuncs(BlockExpr /*P*/ CE, int i, 
                            StringRef funcName, 
                            std.string Tag) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthesizeBlockFunc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3251,
   FQN="(anonymous namespace)::RewriteObjC::SynthesizeBlockFunc", NM="_ZN12_GLOBAL__N_111RewriteObjC19SynthesizeBlockFuncEPN5clang9BlockExprEiN4llvm9StringRefESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC19SynthesizeBlockFuncEPN5clang9BlockExprEiN4llvm9StringRefESs")
  //</editor-fold>
  public std.string SynthesizeBlockFunc(BlockExpr /*P*/ CE, int i, 
                     StringRef funcName, 
                     std.string Tag) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthesizeBlockImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3387,
   FQN="(anonymous namespace)::RewriteObjC::SynthesizeBlockImpl", NM="_ZN12_GLOBAL__N_111RewriteObjC19SynthesizeBlockImplEPN5clang9BlockExprESsSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC19SynthesizeBlockImplEPN5clang9BlockExprESsSs")
  //</editor-fold>
  public std.string SynthesizeBlockImpl(BlockExpr /*P*/ CE, std.string Tag, 
                     std.string Desc) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthesizeBlockDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3502,
   FQN="(anonymous namespace)::RewriteObjC::SynthesizeBlockDescriptor", NM="_ZN12_GLOBAL__N_111RewriteObjC25SynthesizeBlockDescriptorESsSsiN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC25SynthesizeBlockDescriptorESsSsiN4llvm9StringRefEj")
  //</editor-fold>
  public std.string SynthesizeBlockDescriptor(std.string DescTag, 
                           std.string ImplTag, int i, 
                           StringRef FunName, 
                           /*uint*/int hasCopy) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthesizeBlockCall">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3718,
   FQN="(anonymous namespace)::RewriteObjC::SynthesizeBlockCall", NM="_ZN12_GLOBAL__N_111RewriteObjC19SynthesizeBlockCallEPN5clang8CallExprEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC19SynthesizeBlockCallEPN5clang8CallExprEPKNS1_4ExprE")
  //</editor-fold>
  public Stmt /*P*/ SynthesizeBlockCall(CallExpr /*P*/ Exp, /*const*/ Expr /*P*/ BlockExp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthesizeBlockLiterals">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3530,
   FQN="(anonymous namespace)::RewriteObjC::SynthesizeBlockLiterals", NM="_ZN12_GLOBAL__N_111RewriteObjC23SynthesizeBlockLiteralsEN5clang14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23SynthesizeBlockLiteralsEN5clang14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public void SynthesizeBlockLiterals(SourceLocation FunLocStart, 
                         StringRef FunName) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthBlockInitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4344,
   FQN="(anonymous namespace)::RewriteObjC::SynthBlockInitFunctionDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC26SynthBlockInitFunctionDeclEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC26SynthBlockInitFunctionDeclEN4llvm9StringRefE")
  //</editor-fold>
  public FunctionDecl /*P*/ SynthBlockInitFunctionDecl(StringRef name) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::SynthBlockInitExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4352,
   FQN="(anonymous namespace)::RewriteObjC::SynthBlockInitExpr", NM="_ZN12_GLOBAL__N_111RewriteObjC18SynthBlockInitExprEPN5clang9BlockExprERKN4llvm15SmallVectorImplIPNS1_11DeclRefExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC18SynthBlockInitExprEPN5clang9BlockExprERKN4llvm15SmallVectorImplIPNS1_11DeclRefExprEEE")
  //</editor-fold>
  public Stmt /*P*/ SynthBlockInitExpr(BlockExpr /*P*/ Exp, 
                    /*const*/ SmallVectorImpl<DeclRefExpr /*P*/ > /*&*/ InnerBlockDeclRefs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Misc. helper routines.
  
  // typedef struct objc_object Protocol;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::getProtocolType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3021,
   FQN="(anonymous namespace)::RewriteObjC::getProtocolType", NM="_ZN12_GLOBAL__N_111RewriteObjC15getProtocolTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC15getProtocolTypeEv")
  //</editor-fold>
  public QualType getProtocolType() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::WarnAboutReturnGotoStmts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1713,
   FQN="(anonymous namespace)::RewriteObjC::WarnAboutReturnGotoStmts", NM="_ZN12_GLOBAL__N_111RewriteObjC24WarnAboutReturnGotoStmtsEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC24WarnAboutReturnGotoStmtsEPN5clang4StmtE")
  //</editor-fold>
  public void WarnAboutReturnGotoStmts(Stmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::HasReturnStmts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 1726,
   FQN="(anonymous namespace)::RewriteObjC::HasReturnStmts", NM="_ZN12_GLOBAL__N_111RewriteObjC14HasReturnStmtsEPN5clang4StmtERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC14HasReturnStmtsEPN5clang4StmtERb")
  //</editor-fold>
  public void HasReturnStmts(Stmt /*P*/ S, bool$ref/*bool &*/ hasReturns) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::CheckFunctionPointerDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 557,
   FQN="(anonymous namespace)::RewriteObjC::CheckFunctionPointerDecl", NM="_ZN12_GLOBAL__N_111RewriteObjC24CheckFunctionPointerDeclEN5clang8QualTypeEPNS1_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC24CheckFunctionPointerDeclEN5clang8QualTypeEPNS1_9NamedDeclE")
  //</editor-fold>
  public void CheckFunctionPointerDecl(QualType funcType, NamedDecl /*P*/ ND) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::InsertBlockLiteralsWithinFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3618,
   FQN="(anonymous namespace)::RewriteObjC::InsertBlockLiteralsWithinFunction", NM="_ZN12_GLOBAL__N_111RewriteObjC33InsertBlockLiteralsWithinFunctionEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC33InsertBlockLiteralsWithinFunctionEPN5clang12FunctionDeclE")
  //</editor-fold>
  public void InsertBlockLiteralsWithinFunction(FunctionDecl /*P*/ FD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::InsertBlockLiteralsWithinMethod">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3636,
   FQN="(anonymous namespace)::RewriteObjC::InsertBlockLiteralsWithinMethod", NM="_ZN12_GLOBAL__N_111RewriteObjC31InsertBlockLiteralsWithinMethodEPN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC31InsertBlockLiteralsWithinMethodEPN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public void InsertBlockLiteralsWithinMethod(ObjCMethodDecl /*P*/ MD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::IsDeclStmtInForeachHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4545,
   FQN="(anonymous namespace)::RewriteObjC::IsDeclStmtInForeachHeader", NM="_ZN12_GLOBAL__N_111RewriteObjC25IsDeclStmtInForeachHeaderEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC25IsDeclStmtInForeachHeaderEPN5clang8DeclStmtE")
  //</editor-fold>
  public boolean IsDeclStmtInForeachHeader(DeclStmt /*P*/ DS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::CollectBlockDeclRefInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4315,
   FQN="(anonymous namespace)::RewriteObjC::CollectBlockDeclRefInfo", NM="_ZN12_GLOBAL__N_111RewriteObjC23CollectBlockDeclRefInfoEPN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23CollectBlockDeclRefInfoEPN5clang9BlockExprE")
  //</editor-fold>
  public void CollectBlockDeclRefInfo(BlockExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::GetBlockDeclRefExprs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3645,
   FQN="(anonymous namespace)::RewriteObjC::GetBlockDeclRefExprs", NM="_ZN12_GLOBAL__N_111RewriteObjC20GetBlockDeclRefExprsEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC20GetBlockDeclRefExprsEPN5clang4StmtE")
  //</editor-fold>
  public void GetBlockDeclRefExprs(Stmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::GetInnerBlockDeclRefExprs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3661,
   FQN="(anonymous namespace)::RewriteObjC::GetInnerBlockDeclRefExprs", NM="_ZN12_GLOBAL__N_111RewriteObjC25GetInnerBlockDeclRefExprsEPN5clang4StmtERN4llvm15SmallVectorImplIPNS1_11DeclRefExprEEERNS4_15SmallPtrSetImplIPKNS1_11DeclContextEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC25GetInnerBlockDeclRefExprsEPN5clang4StmtERN4llvm15SmallVectorImplIPNS1_11DeclRefExprEEERNS4_15SmallPtrSetImplIPKNS1_11DeclContextEEE")
  //</editor-fold>
  public void GetInnerBlockDeclRefExprs(Stmt /*P*/ S, 
                           SmallVectorImpl<DeclRefExpr /*P*/ > /*&*/ InnerBlockDeclRefs, 
                           SmallPtrSetImpl</*const*/ DeclContext /*P*/ > /*&*/ InnerContexts) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // We avoid calling Type::isBlockPointerType(), since it operates on the
  // canonical type. We only care if the top-level type is a closure pointer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::isTopLevelBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 410,
   FQN="(anonymous namespace)::RewriteObjC::isTopLevelBlockPointerType", NM="_ZN12_GLOBAL__N_111RewriteObjC26isTopLevelBlockPointerTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC26isTopLevelBlockPointerTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isTopLevelBlockPointerType(QualType T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// convertBlockPointerToFunctionPointer - Converts a block-pointer type
  /// to a function pointer type and upon success, returns true; false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::convertBlockPointerToFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 417,
   FQN="(anonymous namespace)::RewriteObjC::convertBlockPointerToFunctionPointer", NM="_ZN12_GLOBAL__N_111RewriteObjC36convertBlockPointerToFunctionPointerERN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC36convertBlockPointerToFunctionPointerERN5clang8QualTypeE")
  //</editor-fold>
  public boolean convertBlockPointerToFunctionPointer(QualType /*&*/ T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::needToScanForQualifiers">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2057,
   FQN="(anonymous namespace)::RewriteObjC::needToScanForQualifiers", NM="_ZN12_GLOBAL__N_111RewriteObjC23needToScanForQualifiersEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC23needToScanForQualifiersEN5clang8QualTypeE")
  //</editor-fold>
  public boolean needToScanForQualifiers(QualType T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // struct objc_super { struct objc_object *receiver; struct objc_class *super; };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::getSuperStructType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2523,
   FQN="(anonymous namespace)::RewriteObjC::getSuperStructType", NM="_ZN12_GLOBAL__N_111RewriteObjC18getSuperStructTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC18getSuperStructTypeEv")
  //</editor-fold>
  public QualType getSuperStructType() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::getConstantStringStructType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2551,
   FQN="(anonymous namespace)::RewriteObjC::getConstantStringStructType", NM="_ZN12_GLOBAL__N_111RewriteObjC27getConstantStringStructTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC27getConstantStringStructTypeEv")
  //</editor-fold>
  public QualType getConstantStringStructType() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// convertFunctionTypeOfBlocks - This routine converts a function type
  /// whose result type may be a block pointer or whose argument type(s)
  /// might be block pointers to an equivalent function type replacing
  /// all block pointers to function pointers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::convertFunctionTypeOfBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3692,
   FQN="(anonymous namespace)::RewriteObjC::convertFunctionTypeOfBlocks", NM="_ZN12_GLOBAL__N_111RewriteObjC27convertFunctionTypeOfBlocksEPKN5clang12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC27convertFunctionTypeOfBlocksEPKN5clang12FunctionTypeE")
  //</editor-fold>
  public QualType convertFunctionTypeOfBlocks(/*const*/ FunctionType /*P*/ FT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::BufferContainsPPDirectives">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3057,
   FQN="(anonymous namespace)::RewriteObjC::BufferContainsPPDirectives", NM="_ZN12_GLOBAL__N_111RewriteObjC26BufferContainsPPDirectivesEPKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC26BufferContainsPPDirectivesEPKcS2_")
  //</editor-fold>
  public boolean BufferContainsPPDirectives(/*const*/char$ptr/*char P*/ startBuf, 
                            /*const*/char$ptr/*char P*/ endBuf) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::convertToUnqualifiedObjCType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 432,
   FQN="(anonymous namespace)::RewriteObjC::convertToUnqualifiedObjCType", NM="_ZN12_GLOBAL__N_111RewriteObjC28convertToUnqualifiedObjCTypeERN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC28convertToUnqualifiedObjCTypeERN5clang8QualTypeE")
  //</editor-fold>
  public void convertToUnqualifiedObjCType(QualType /*&*/ T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // FIXME: This predicate seems like it would be useful to add to ASTContext.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::isObjCType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 449,
   FQN="(anonymous namespace)::RewriteObjC::isObjCType", NM="_ZN12_GLOBAL__N_111RewriteObjC10isObjCTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC10isObjCTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isObjCType(QualType T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::PointerTypeTakesAnyBlockArguments">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3957,
   FQN="(anonymous namespace)::RewriteObjC::PointerTypeTakesAnyBlockArguments", NM="_ZN12_GLOBAL__N_111RewriteObjC33PointerTypeTakesAnyBlockArgumentsEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC33PointerTypeTakesAnyBlockArgumentsEN5clang8QualTypeE")
  //</editor-fold>
  public boolean PointerTypeTakesAnyBlockArguments(QualType QT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::PointerTypeTakesAnyObjCQualifiedType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3975,
   FQN="(anonymous namespace)::RewriteObjC::PointerTypeTakesAnyObjCQualifiedType", NM="_ZN12_GLOBAL__N_111RewriteObjC36PointerTypeTakesAnyObjCQualifiedTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC36PointerTypeTakesAnyObjCQualifiedTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean PointerTypeTakesAnyObjCQualifiedType(QualType QT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::GetExtentOfArgList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3998,
   FQN="(anonymous namespace)::RewriteObjC::GetExtentOfArgList", NM="_ZN12_GLOBAL__N_111RewriteObjC18GetExtentOfArgListEPKcRS2_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC18GetExtentOfArgListEPKcRS2_S3_")
  //</editor-fold>
  public void GetExtentOfArgList(/*const*/char$ptr/*char P*/ Name, char$ptr/*const char P &*/ LParen, 
                    char$ptr/*const char P &*/ RParen) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::QuoteDoublequotes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 471,
   FQN="(anonymous namespace)::RewriteObjC::QuoteDoublequotes", NM="_ZN12_GLOBAL__N_111RewriteObjC17QuoteDoublequotesERSsS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC17QuoteDoublequotesERSsS1_")
  //</editor-fold>
  public void QuoteDoublequotes(std.string/*&*/ From, std.string/*&*/ To) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::getSimpleFunctionType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 480,
   FQN="(anonymous namespace)::RewriteObjC::getSimpleFunctionType", NM="_ZN12_GLOBAL__N_111RewriteObjC21getSimpleFunctionTypeEN5clang8QualTypeEN4llvm8ArrayRefIS2_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC21getSimpleFunctionTypeEN5clang8QualTypeEN4llvm8ArrayRefIS2_EEb")
  //</editor-fold>
  public QualType getSimpleFunctionType(QualType result, 
                       ArrayRef<QualType> args) {
    return getSimpleFunctionType(result, 
                       args, 
                       false);
  }
  public QualType getSimpleFunctionType(QualType result, 
                       ArrayRef<QualType> args, 
                       boolean variadic/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Helper function: create a CStyleCastExpr with trivial type source info.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::NoTypeInfoCStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 491,
   FQN="(anonymous namespace)::RewriteObjC::NoTypeInfoCStyleCastExpr", NM="_ZN12_GLOBAL__N_111RewriteObjC24NoTypeInfoCStyleCastExprEPN5clang10ASTContextENS1_8QualTypeENS1_8CastKindEPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC24NoTypeInfoCStyleCastExprEPN5clang10ASTContextENS1_8QualTypeENS1_8CastKindEPNS1_4ExprE")
  //</editor-fold>
  public CStyleCastExpr /*P*/ NoTypeInfoCStyleCastExpr(ASTContext /*P*/ Ctx, QualType Ty, 
                          CastKind Kind, Expr /*P*/ E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjC::getStringLiteral">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 498,
   FQN="(anonymous namespace)::RewriteObjC::getStringLiteral", NM="_ZN12_GLOBAL__N_111RewriteObjC16getStringLiteralEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_111RewriteObjC16getStringLiteralEN4llvm9StringRefE")
  //</editor-fold>
  public StringLiteral /*P*/ getStringLiteral(StringRef Str) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Rewrite=" + Rewrite // NOI18N
              + ", Diags=" + Diags // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", Context=" + Context // NOI18N
              + ", SM=" + SM // NOI18N
              + ", TUDecl=" + TUDecl // NOI18N
              + ", MainFileID=" + MainFileID // NOI18N
              + ", MainFileStart=" + MainFileStart // NOI18N
              + ", MainFileEnd=" + MainFileEnd // NOI18N
              + ", CurrentBody=" + CurrentBody // NOI18N
              + ", PropParentMap=" + PropParentMap // NOI18N
              + ", InFileName=" + InFileName // NOI18N
              + ", OutFile=" + OutFile // NOI18N
              + ", Preamble=" + Preamble // NOI18N
              + ", ProtocolTypeDecl=" + ProtocolTypeDecl // NOI18N
              + ", GlobalVarDecl=" + GlobalVarDecl // NOI18N
              + ", RewriteFailedDiag=" + RewriteFailedDiag // NOI18N
              + ", NumObjCStringLiterals=" + NumObjCStringLiterals // NOI18N
              + ", ConstantStringClassReference=" + ConstantStringClassReference // NOI18N
              + ", NSStringRecord=" + NSStringRecord // NOI18N
              + ", BcLabelCount=" + BcLabelCount // NOI18N
              + ", TryFinallyContainsReturnDiag=" + TryFinallyContainsReturnDiag // NOI18N
              + ", CurMethodDef=" + CurMethodDef // NOI18N
              + ", SuperStructDecl=" + SuperStructDecl // NOI18N
              + ", ConstantStringDecl=" + ConstantStringDecl // NOI18N
              + ", MsgSendFunctionDecl=" + MsgSendFunctionDecl // NOI18N
              + ", MsgSendSuperFunctionDecl=" + MsgSendSuperFunctionDecl // NOI18N
              + ", MsgSendStretFunctionDecl=" + MsgSendStretFunctionDecl // NOI18N
              + ", MsgSendSuperStretFunctionDecl=" + MsgSendSuperStretFunctionDecl // NOI18N
              + ", MsgSendFpretFunctionDecl=" + MsgSendFpretFunctionDecl // NOI18N
              + ", GetClassFunctionDecl=" + GetClassFunctionDecl // NOI18N
              + ", GetMetaClassFunctionDecl=" + GetMetaClassFunctionDecl // NOI18N
              + ", GetSuperClassFunctionDecl=" + GetSuperClassFunctionDecl // NOI18N
              + ", SelGetUidFunctionDecl=" + SelGetUidFunctionDecl // NOI18N
              + ", CFStringFunctionDecl=" + CFStringFunctionDecl // NOI18N
              + ", SuperConstructorFunctionDecl=" + SuperConstructorFunctionDecl // NOI18N
              + ", CurFunctionDef=" + CurFunctionDef // NOI18N
              + ", CurFunctionDeclToDeclareForBlock=" + CurFunctionDeclToDeclareForBlock // NOI18N
              + ", ClassImplementation=" + ClassImplementation // NOI18N
              + ", CategoryImplementation=" + CategoryImplementation // NOI18N
              + ", ObjCSynthesizedStructs=" + ObjCSynthesizedStructs // NOI18N
              + ", ObjCSynthesizedProtocols=" + ObjCSynthesizedProtocols // NOI18N
              + ", ObjCForwardDecls=" + ObjCForwardDecls // NOI18N
              + ", MethodInternalNames=" + MethodInternalNames // NOI18N
              + ", Stmts=" + Stmts // NOI18N
              + ", ObjCBcLabelNo=" + ObjCBcLabelNo // NOI18N
              + ", ProtocolExprDecls=" + ProtocolExprDecls // NOI18N
              + ", CopyDestroyCache=" + CopyDestroyCache // NOI18N
              + ", Blocks=" + Blocks // NOI18N
              + ", InnerDeclRefsCount=" + InnerDeclRefsCount // NOI18N
              + ", InnerDeclRefs=" + InnerDeclRefs // NOI18N
              + ", BlockDeclRefs=" + BlockDeclRefs // NOI18N
              + ", BlockByCopyDecls=" + BlockByCopyDecls // NOI18N
              + ", BlockByCopyDeclsPtrSet=" + BlockByCopyDeclsPtrSet // NOI18N
              + ", BlockByRefDecls=" + BlockByRefDecls // NOI18N
              + ", BlockByRefDeclsPtrSet=" + BlockByRefDeclsPtrSet // NOI18N
              + ", BlockByRefDeclNo=" + BlockByRefDeclNo // NOI18N
              + ", ImportedBlockDecls=" + ImportedBlockDecls // NOI18N
              + ", ImportedLocalExternalDecls=" + ImportedLocalExternalDecls // NOI18N
              + ", RewrittenBlockExprs=" + RewrittenBlockExprs // NOI18N
              + ", ReplacedNodes=" + ReplacedNodes // NOI18N
              + ", IsHeader=" + IsHeader // NOI18N
              + ", SilenceRewriteMacroWarning=" + SilenceRewriteMacroWarning // NOI18N
              + ", objc_impl_method=" + objc_impl_method // NOI18N
              + ", DisableReplaceStmt=" + DisableReplaceStmt // NOI18N
              + super.toString(); // NOI18N
  }
}
