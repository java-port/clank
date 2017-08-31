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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 39,
 FQN="(anonymous namespace)::RewriteModernObjC", NM="_ZN12_GLOBAL__N_117RewriteModernObjCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjCE")
//</editor-fold>
public class RewriteModernObjC extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 42,
   FQN="(anonymous namespace)::RewriteModernObjC::(anonymous)", NM="_ZN12_GLOBAL__N_117RewriteModernObjCE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjCE_Unnamed_enum")
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 55,
   FQN="(anonymous namespace)::RewriteModernObjC::(anonymous)", NM="_ZN12_GLOBAL__N_117RewriteModernObjCE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjCE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int BLOCK_NEEDS_FREE = (1 << 24);
    public static final /*uint*/int BLOCK_HAS_COPY_DISPOSE = (1 << 25);
    public static final /*uint*/int BLOCK_HAS_CXX_OBJ = (1 << 26);
    public static final /*uint*/int BLOCK_IS_GC = (1 << 27);
    public static final /*uint*/int BLOCK_IS_GLOBAL = (1 << 28);
    public static final /*uint*/int BLOCK_HAS_DESCRIPTOR = (1 << 29);
  /*}*/;
  
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
  protected Expr /*P*/ GlobalConstructionExp;
  protected /*uint*/int RewriteFailedDiag;
  protected /*uint*/int GlobalBlockRewriteFailedDiag;
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
  
  /* Misc. containers needed for meta-data rewrite. */
  protected SmallVector<ObjCImplementationDecl /*P*/ > ClassImplementation;
  protected SmallVector<ObjCCategoryImplDecl /*P*/ > CategoryImplementation;
  protected SmallPtrSet<ObjCInterfaceDecl /*P*/ > ObjCSynthesizedStructs;
  protected SmallPtrSet<ObjCProtocolDecl /*P*/ > ObjCSynthesizedProtocols;
  protected SmallPtrSet<ObjCInterfaceDecl /*P*/ > ObjCWrittenInterfaces;
  protected SmallPtrSet<TagDecl /*P*/ > GlobalDefinedTags;
  protected SmallVector<ObjCInterfaceDecl /*P*/ > ObjCInterfacesSeen;
  /// DefinedNonLazyClasses - List of defined "non-lazy" classes.
  protected SmallVector<ObjCInterfaceDecl /*P*/ > DefinedNonLazyClasses;
  
  /// DefinedNonLazyCategories - List of defined "non-lazy" categories.
  protected SmallVector<ObjCCategoryDecl /*P*/ > DefinedNonLazyCategories;
  
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
  protected DenseMap<ObjCInterfaceDecl /*P*/ , SmallPtrSet<ObjCIvarDecl /*P*/ > > ReferencedIvars;
  
  // ivar bitfield grouping containers
  protected DenseSet</*const*/ ObjCInterfaceDecl /*P*/ > ObjCInterefaceHasBitfieldGroups;
  protected DenseMapTypeUInt</*const*/ ObjCIvarDecl /*P*/ > IvarGroupNumber;
  // This container maps an <class, group number for ivar> tuple to the type
  // of the struct where the bitfield belongs.
  protected DenseMap<std.pairTypeUInt</*const*/ ObjCInterfaceDecl /*P*/ >, QualType> GroupRecordType;
  protected SmallVector<FunctionDecl /*P*/ > FunctionDefinitionsSeen;
  
  // This maps an original source AST to it's rewritten form. This allows
  // us to avoid rewriting the same node twice (which is very uncommon).
  // This is needed to support some of the exotic property rewriting.
  protected DenseMap<Stmt /*P*/ , Stmt /*P*/ > ReplacedNodes;
  
  // Needed for header files being rewritten
  protected boolean IsHeader;
  protected boolean SilenceRewriteMacroWarning;
  protected boolean GenerateLineInfo;
  protected boolean objc_impl_method;
  
  protected boolean DisableReplaceStmt;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::DisableReplaceStmtScope">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 171,
   FQN="(anonymous namespace)::RewriteModernObjC::DisableReplaceStmtScope", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23DisableReplaceStmtScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23DisableReplaceStmtScopeE")
  //</editor-fold>
  protected static class DisableReplaceStmtScope implements Destructors.ClassWithDestructor {
    private RewriteModernObjC /*&*/ R;
    private boolean SavedValue;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::DisableReplaceStmtScope::DisableReplaceStmtScope">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 176,
     FQN="(anonymous namespace)::RewriteModernObjC::DisableReplaceStmtScope::DisableReplaceStmtScope", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23DisableReplaceStmtScopeC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23DisableReplaceStmtScopeC1ERS0_")
    //</editor-fold>
    public DisableReplaceStmtScope(RewriteModernObjC /*&*/ R) {
      // : R(R), SavedValue(R.DisableReplaceStmt) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::DisableReplaceStmtScope::~DisableReplaceStmtScope">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 180,
     FQN="(anonymous namespace)::RewriteModernObjC::DisableReplaceStmtScope::~DisableReplaceStmtScope", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23DisableReplaceStmtScopeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23DisableReplaceStmtScopeD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "R=" + R // NOI18N
                + ", SavedValue=" + SavedValue; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::InitializeCommon">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 671,
   FQN="(anonymous namespace)::RewriteModernObjC::InitializeCommon", NM="_ZN12_GLOBAL__N_117RewriteModernObjC16InitializeCommonERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC16InitializeCommonERN5clang10ASTContextE")
  //</editor-fold>
  protected void InitializeCommon(ASTContext /*&*/ context) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  public DenseMap<ObjCMethodDecl /*P*/ , std.string> MethodInternalNames;
  
  // Top Level Driver code.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 190,
   FQN="(anonymous namespace)::RewriteModernObjC::HandleTopLevelDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC18HandleTopLevelDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC18HandleTopLevelDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef D)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::HandleTopLevelDeclInObjCContainer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 227,
   FQN="(anonymous namespace)::RewriteModernObjC::HandleTopLevelDeclInObjCContainer", NM="_ZN12_GLOBAL__N_117RewriteModernObjC33HandleTopLevelDeclInObjCContainerEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC33HandleTopLevelDeclInObjCContainerEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public void HandleTopLevelDeclInObjCContainer(DeclGroupRef D)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  //===----------------------------------------------------------------------===//
  // Top Level Driver Code
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::HandleTopLevelSingleDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 715,
   FQN="(anonymous namespace)::RewriteModernObjC::HandleTopLevelSingleDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24HandleTopLevelSingleDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24HandleTopLevelSingleDeclEPN5clang4DeclE")
  //</editor-fold>
  public void HandleTopLevelSingleDecl(Decl /*P*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// HandleDeclInMainFile - This is called for each top-level decl defined in the
  /// main file of the input.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::HandleDeclInMainFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5697,
   FQN="(anonymous namespace)::RewriteModernObjC::HandleDeclInMainFile", NM="_ZN12_GLOBAL__N_117RewriteModernObjC20HandleDeclInMainFileEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC20HandleDeclInMainFileEPN5clang4DeclE")
  //</editor-fold>
  public void HandleDeclInMainFile(Decl /*P*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteModernObjC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 641,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteModernObjC", NM="_ZN12_GLOBAL__N_117RewriteModernObjCC1ESsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EERN5clang17DiagnosticsEngineERKNS7_11LangOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjCC1ESsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EERN5clang17DiagnosticsEngineERKNS7_11LangOptionsEbb")
  //</editor-fold>
  public RewriteModernObjC(std.string inFile, 
      std.unique_ptr<raw_ostream> OS, 
      DiagnosticsEngine /*&*/ D, 
      /*const*/ LangOptions /*&*/ LOpts, 
      boolean silenceMacroWarn, boolean LineInfo) {
    // : ASTConsumer(), Rewrite(), Diags(D), LangOpts(LOpts), MainFileID(), InFileName(inFile), OutFile(std::move(OS)), Preamble(), ClassImplementation(), CategoryImplementation(), ObjCSynthesizedStructs(), ObjCSynthesizedProtocols(), ObjCWrittenInterfaces(), GlobalDefinedTags(), ObjCInterfacesSeen(), DefinedNonLazyClasses(), DefinedNonLazyCategories(), Stmts(), ObjCBcLabelNo(), ProtocolExprDecls(), CopyDestroyCache(), Blocks(), InnerDeclRefsCount(), InnerDeclRefs(), BlockDeclRefs(), BlockByCopyDecls(), BlockByCopyDeclsPtrSet(), BlockByRefDecls(), BlockByRefDeclsPtrSet(), BlockByRefDeclNo(), ImportedBlockDecls(), ImportedLocalExternalDecls(), RewrittenBlockExprs(), ReferencedIvars(), ObjCInterefaceHasBitfieldGroups(), IvarGroupNumber(), GroupRecordType(), FunctionDefinitionsSeen(), ReplacedNodes(), SilenceRewriteMacroWarning(silenceMacroWarn), GenerateLineInfo(LineInfo), MethodInternalNames() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::~RewriteModernObjC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 246,
   FQN="(anonymous namespace)::RewriteModernObjC::~RewriteModernObjC", NM="_ZN12_GLOBAL__N_117RewriteModernObjCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjCD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5839,
   FQN="(anonymous namespace)::RewriteModernObjC::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_117RewriteModernObjC21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(ASTContext /*&*/ C)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::ReplaceStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 250,
   FQN="(anonymous namespace)::RewriteModernObjC::ReplaceStmt", NM="_ZN12_GLOBAL__N_117RewriteModernObjC11ReplaceStmtEPN5clang4StmtES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC11ReplaceStmtEPN5clang4StmtES3_")
  //</editor-fold>
  public void ReplaceStmt(Stmt /*P*/ Old, Stmt /*P*/ New) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::ReplaceStmtWithRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 254,
   FQN="(anonymous namespace)::RewriteModernObjC::ReplaceStmtWithRange", NM="_ZN12_GLOBAL__N_117RewriteModernObjC20ReplaceStmtWithRangeEPN5clang4StmtES3_NS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC20ReplaceStmtWithRangeEPN5clang4StmtES3_NS1_11SourceRangeE")
  //</editor-fold>
  public void ReplaceStmtWithRange(Stmt /*P*/ Old, Stmt /*P*/ New, SourceRange SrcRange) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::InsertText">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 288,
   FQN="(anonymous namespace)::RewriteModernObjC::InsertText", NM="_ZN12_GLOBAL__N_117RewriteModernObjC10InsertTextEN5clang14SourceLocationEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC10InsertTextEN5clang14SourceLocationEN4llvm9StringRefEb")
  //</editor-fold>
  public void InsertText(SourceLocation Loc, StringRef Str) {
    InsertText(Loc, Str, 
            true);
  }
  public void InsertText(SourceLocation Loc, StringRef Str, 
            boolean InsertAfter/*= true*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::ReplaceText">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 298,
   FQN="(anonymous namespace)::RewriteModernObjC::ReplaceText", NM="_ZN12_GLOBAL__N_117RewriteModernObjC11ReplaceTextEN5clang14SourceLocationEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC11ReplaceTextEN5clang14SourceLocationEjN4llvm9StringRefE")
  //</editor-fold>
  public void ReplaceText(SourceLocation Start, /*uint*/int OrigLength, 
             StringRef Str) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Syntactic Rewriting.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteRecordBody">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5685,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteRecordBody", NM="_ZN12_GLOBAL__N_117RewriteModernObjC17RewriteRecordBodyEPN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC17RewriteRecordBodyEPN5clang10RecordDeclE")
  //</editor-fold>
  public void RewriteRecordBody(RecordDecl /*P*/ RD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===----------------------------------------------------------------------===//
  // Syntactic (non-AST) Rewriting Code
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteInclude">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 804,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteInclude", NM="_ZN12_GLOBAL__N_117RewriteModernObjC14RewriteIncludeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC14RewriteIncludeEv")
  //</editor-fold>
  public void RewriteInclude() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteLineDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3058,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteLineDirective", NM="_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteLineDirectiveEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteLineDirectiveEPKN5clang4DeclE")
  //</editor-fold>
  public void RewriteLineDirective(/*const*/ Decl /*P*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::ConvertSourceLocationToLineDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1618,
   FQN="(anonymous namespace)::RewriteModernObjC::ConvertSourceLocationToLineDirective", NM="_ZN12_GLOBAL__N_117RewriteModernObjC36ConvertSourceLocationToLineDirectiveEN5clang14SourceLocationERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC36ConvertSourceLocationToLineDirectiveEN5clang14SourceLocationERSs")
  //</editor-fold>
  public void ConvertSourceLocationToLineDirective(SourceLocation Loc, 
                                      std.string/*&*/ LineString) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteForwardClassDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1070,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteForwardClassDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteForwardClassDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteForwardClassDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  public void RewriteForwardClassDecl(DeclGroupRef D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteForwardClassDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1091,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteForwardClassDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteForwardClassDeclERKN4llvm15SmallVectorImplIPN5clang4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteForwardClassDeclERKN4llvm15SmallVectorImplIPN5clang4DeclEEE")
  //</editor-fold>
  public void RewriteForwardClassDecl(/*const*/ SmallVectorImpl<Decl /*P*/ > /*&*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteForwardClassEpilogue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1061,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteForwardClassEpilogue", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteForwardClassEpilogueEPN5clang17ObjCInterfaceDeclERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteForwardClassEpilogueEPN5clang17ObjCInterfaceDeclERKSs")
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteImplementations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4008,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteImplementations", NM="_ZN12_GLOBAL__N_117RewriteModernObjC22RewriteImplementationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC22RewriteImplementationsEv")
  //</editor-fold>
  public void RewriteImplementations() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewritePropertyImplDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 918,
   FQN="(anonymous namespace)::RewriteModernObjC::RewritePropertyImplDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23RewritePropertyImplDeclEPN5clang20ObjCPropertyImplDeclEPNS1_22ObjCImplementationDeclEPNS1_20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23RewritePropertyImplDeclEPN5clang20ObjCPropertyImplDeclEPNS1_22ObjCImplementationDeclEPNS1_20ObjCCategoryImplDeclE")
  //</editor-fold>
  public void RewritePropertyImplDecl(ObjCPropertyImplDecl /*P*/ PID, 
                         ObjCImplementationDecl /*P*/ IMD, 
                         ObjCCategoryImplDecl /*P*/ CID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1377,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteInterfaceDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteInterfaceDeclEPN5clang17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteInterfaceDeclEPN5clang17ObjCInterfaceDeclE")
  //</editor-fold>
  public void RewriteInterfaceDecl(ObjCInterfaceDecl /*P*/ ClassDecl) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteImplementationDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1334,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteImplementationDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25RewriteImplementationDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25RewriteImplementationDeclEPN5clang4DeclE")
  //</editor-fold>
  public void RewriteImplementationDecl(Decl /*P*/ OID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1230,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCMethodDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC21RewriteObjCMethodDeclEPKN5clang17ObjCInterfaceDeclEPNS1_14ObjCMethodDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC21RewriteObjCMethodDeclEPKN5clang17ObjCInterfaceDeclEPNS1_14ObjCMethodDeclERSs")
  //</editor-fold>
  public void RewriteObjCMethodDecl(/*const*/ ObjCInterfaceDecl /*P*/ IDecl, 
                       ObjCMethodDecl /*P*/ OMD, 
                       std.string/*&*/ ResultStr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteTypeIntoString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1207,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteTypeIntoString", NM="_ZN12_GLOBAL__N_117RewriteModernObjC21RewriteTypeIntoStringEN5clang8QualTypeERSsRPKNS1_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC21RewriteTypeIntoStringEN5clang8QualTypeERSsRPKNS1_12FunctionTypeE")
  //</editor-fold>
  public void RewriteTypeIntoString(QualType T, std.string/*&*/ ResultStr, 
                       /*const*/ FunctionType /*P*/ /*&*/ FPRetType) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteByRefString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4032,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteByRefString", NM="_ZN12_GLOBAL__N_117RewriteModernObjC18RewriteByRefStringERSsRKSsPN5clang9ValueDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC18RewriteByRefStringERSsRKSsPN5clang9ValueDeclEb")
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

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1130,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteCategoryDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC19RewriteCategoryDeclEPN5clang16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC19RewriteCategoryDeclEPN5clang16ObjCCategoryDeclE")
  //</editor-fold>
  public void RewriteCategoryDecl(ObjCCategoryDecl /*P*/ CatDecl) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1155,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteProtocolDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC19RewriteProtocolDeclEPN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC19RewriteProtocolDeclEPN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  public void RewriteProtocolDecl(ObjCProtocolDecl /*P*/ PDecl) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteForwardProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1190,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteForwardProtocolDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC26RewriteForwardProtocolDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC26RewriteForwardProtocolDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  public void RewriteForwardProtocolDecl(DeclGroupRef D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteForwardProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1198,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteForwardProtocolDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC26RewriteForwardProtocolDeclERKN4llvm15SmallVectorImplIPN5clang4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC26RewriteForwardProtocolDeclERKN4llvm15SmallVectorImplIPN5clang4DeclEEE")
  //</editor-fold>
  public void RewriteForwardProtocolDecl(/*const*/ SmallVectorImpl<Decl /*P*/ > /*&*/ DG) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteMethodDeclaration">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1106,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteMethodDeclaration", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteMethodDeclarationEPN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteMethodDeclarationEPN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public void RewriteMethodDeclaration(ObjCMethodDecl /*P*/ Method) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteProperty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1123,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteProperty", NM="_ZN12_GLOBAL__N_117RewriteModernObjC15RewritePropertyEPN5clang16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC15RewritePropertyEPN5clang16ObjCPropertyDeclE")
  //</editor-fold>
  public void RewriteProperty(ObjCPropertyDecl /*P*/ prop) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2325,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC19RewriteFunctionDeclEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC19RewriteFunctionDeclEPN5clang12FunctionDeclE")
  //</editor-fold>
  public void RewriteFunctionDecl(FunctionDecl /*P*/ FD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2335,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteBlockPointerType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteBlockPointerTypeERSsN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteBlockPointerTypeERSsN5clang8QualTypeE")
  //</editor-fold>
  public void RewriteBlockPointerType(std.string/*&*/ Str, QualType Type) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // FIXME. Consolidate this routine with RewriteBlockPointerType.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteBlockPointerTypeVariable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2349,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteBlockPointerTypeVariable", NM="_ZN12_GLOBAL__N_117RewriteModernObjC31RewriteBlockPointerTypeVariableERSsPN5clang9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC31RewriteBlockPointerTypeVariableERSsPN5clang9ValueDeclE")
  //</editor-fold>
  public void RewriteBlockPointerTypeVariable(std.string/*&*/ Str, 
                                 ValueDecl /*P*/ VD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteBlockLiteralFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2378,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteBlockLiteralFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC31RewriteBlockLiteralFunctionDeclEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC31RewriteBlockLiteralFunctionDeclEPN5clang12FunctionDeclE")
  //</editor-fold>
  public void RewriteBlockLiteralFunctionDecl(FunctionDecl /*P*/ FD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCQualifiedInterfaceTypes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2193,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCQualifiedInterfaceTypes", NM="_ZN12_GLOBAL__N_117RewriteModernObjC34RewriteObjCQualifiedInterfaceTypesEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC34RewriteObjCQualifiedInterfaceTypesEPN5clang4DeclE")
  //</editor-fold>
  public void RewriteObjCQualifiedInterfaceTypes(Decl /*P*/ Dcl) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteTypeOfDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2275,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteTypeOfDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC17RewriteTypeOfDeclEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC17RewriteTypeOfDeclEPN5clang7VarDeclE")
  //</editor-fold>
  public void RewriteTypeOfDecl(VarDecl /*P*/ ND) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCQualifiedInterfaceTypes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2163,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCQualifiedInterfaceTypes", NM="_ZN12_GLOBAL__N_117RewriteModernObjC34RewriteObjCQualifiedInterfaceTypesEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC34RewriteObjCQualifiedInterfaceTypesEPN5clang4ExprE")
  //</editor-fold>
  public void RewriteObjCQualifiedInterfaceTypes(Expr /*P*/ E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::getIvarAccessString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 838,
   FQN="(anonymous namespace)::RewriteModernObjC::getIvarAccessString", NM="_ZN12_GLOBAL__N_117RewriteModernObjC19getIvarAccessStringEPN5clang12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC19getIvarAccessStringEPN5clang12ObjCIvarDeclE")
  //</editor-fold>
  public std.string getIvarAccessString(ObjCIvarDecl /*P*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Expression Rewriting.
  
  //===----------------------------------------------------------------------===//
  // Function Body / Expression rewriting
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteFunctionBodyOrGlobalInitializer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5444,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteFunctionBodyOrGlobalInitializer", NM="_ZN12_GLOBAL__N_117RewriteModernObjC38RewriteFunctionBodyOrGlobalInitializerEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC38RewriteFunctionBodyOrGlobalInitializerEPN5clang4StmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteFunctionBodyOrGlobalInitializer(Stmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteAtEncode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2064,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteAtEncode", NM="_ZN12_GLOBAL__N_117RewriteModernObjC15RewriteAtEncodeEPN5clang14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC15RewriteAtEncodeEPN5clang14ObjCEncodeExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteAtEncode(ObjCEncodeExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewritePropertyOrImplicitGetter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1498,
   FQN="(anonymous namespace)::RewriteModernObjC::RewritePropertyOrImplicitGetter", NM="_ZN12_GLOBAL__N_117RewriteModernObjC31RewritePropertyOrImplicitGetterEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC31RewritePropertyOrImplicitGetterEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public Stmt /*P*/ RewritePropertyOrImplicitGetter(PseudoObjectExpr /*P*/ PseudoOp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewritePropertyOrImplicitSetter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1410,
   FQN="(anonymous namespace)::RewriteModernObjC::RewritePropertyOrImplicitSetter", NM="_ZN12_GLOBAL__N_117RewriteModernObjC31RewritePropertyOrImplicitSetterEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC31RewritePropertyOrImplicitSetterEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public Stmt /*P*/ RewritePropertyOrImplicitSetter(PseudoObjectExpr /*P*/ PseudoOp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteAtSelector">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2076,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteAtSelector", NM="_ZN12_GLOBAL__N_117RewriteModernObjC17RewriteAtSelectorEPN5clang16ObjCSelectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC17RewriteAtSelectorEPN5clang16ObjCSelectorExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteAtSelector(ObjCSelectorExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteMessageExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3564,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteMessageExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC18RewriteMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC18RewriteMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteMessageExpr(ObjCMessageExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2555,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCStringLiteral", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteObjCStringLiteralEPN5clang17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteObjCStringLiteralEPN5clang17ObjCStringLiteralE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCStringLiteral(ObjCStringLiteral /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2601,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCBoolLiteralExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC26RewriteObjCBoolLiteralExprEPN5clang19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC26RewriteObjCBoolLiteralExprEPN5clang19ObjCBoolLiteralExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCBoolLiteralExpr(ObjCBoolLiteralExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2616,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCBoxedExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteObjCBoxedExprEPN5clang13ObjCBoxedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteObjCBoxedExprEPN5clang13ObjCBoxedExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCBoxedExpr(ObjCBoxedExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCArrayLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2700,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCArrayLiteralExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteObjCArrayLiteralExprEPN5clang16ObjCArrayLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteObjCArrayLiteralExprEPN5clang16ObjCArrayLiteralE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCArrayLiteralExpr(ObjCArrayLiteral /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCDictionaryLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2823,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCDictionaryLiteralExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC32RewriteObjCDictionaryLiteralExprEPN5clang21ObjCDictionaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC32RewriteObjCDictionaryLiteralExprEPN5clang21ObjCDictionaryLiteralE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCDictionaryLiteralExpr(ObjCDictionaryLiteral /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteObjCProtocolExpr - Rewrite a protocol expression into
  /// a synthesized/forward data reference (to the protocol's metadata).
  /// The forward references (and metadata) are generated in
  /// RewriteModernObjC::HandleTranslationUnit().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3592,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCProtocolExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteObjCProtocolExprEPN5clang16ObjCProtocolExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteObjCProtocolExprEPN5clang16ObjCProtocolExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCProtocolExpr(ObjCProtocolExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCTryStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1931,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCTryStmt", NM="_ZN12_GLOBAL__N_117RewriteModernObjC18RewriteObjCTryStmtEPN5clang13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC18RewriteObjCTryStmtEPN5clang13ObjCAtTryStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCTryStmt(ObjCAtTryStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1922,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCAutoreleasePoolStmt", NM="_ZN12_GLOBAL__N_117RewriteModernObjC30RewriteObjCAutoreleasePoolStmtEPN5clang23ObjCAutoreleasePoolStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC30RewriteObjCAutoreleasePoolStmtEPN5clang23ObjCAutoreleasePoolStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCAutoreleasePoolStmt(ObjCAutoreleasePoolStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteObjCSynchronizedStmt -
  /// This routine rewrites @synchronized(expr) stmt;
  /// into:
  /// objc_sync_enter(expr);
  /// @try stmt @finally { objc_sync_exit(expr); }
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1860,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCSynchronizedStmt", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteObjCSynchronizedStmtEPN5clang22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteObjCSynchronizedStmtEPN5clang22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCSynchronizedStmt(ObjCAtSynchronizedStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // This can't be done with ReplaceStmt(S, ThrowExpr), since
  // the throw expression is typically a message expression that's already
  // been rewritten! (which implies the SourceLocation's are invalid).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCThrowStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2035,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCThrowStmt", NM="_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteObjCThrowStmtEPN5clang15ObjCAtThrowStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteObjCThrowStmtEPN5clang15ObjCAtThrowStmtE")
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
  ///   NSUInteger limit = [l_collection countByEnumeratingWithState:&enumState
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
  ///   } while ((limit = [l_collection countByEnumeratingWithState:&enumState
  ///                                  objects:__rw_items count:16]));
  ///   elem = nil;
  ///   __break_label: ;
  ///  }
  ///  else
  ///       elem = nil;
  ///  }
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1680,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCForCollectionStmt", NM="_ZN12_GLOBAL__N_117RewriteModernObjC28RewriteObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC28RewriteObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtENS1_14SourceLocationE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ S, 
                              SourceLocation OrigEnd) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteBreakStmt - Rewrite for a break-stmt inside an ObjC2's foreach
  /// statement to exit to its outer synthesized loop.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteBreakStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1604,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteBreakStmt", NM="_ZN12_GLOBAL__N_117RewriteModernObjC16RewriteBreakStmtEPN5clang9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC16RewriteBreakStmtEPN5clang9BreakStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteBreakStmt(BreakStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteContinueStmt - Rewrite for a continue-stmt inside an ObjC2's foreach
  /// statement to continue with its inner synthesized loop.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteContinueStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1634,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteContinueStmt", NM="_ZN12_GLOBAL__N_117RewriteModernObjC19RewriteContinueStmtEPN5clang12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC19RewriteContinueStmtEPN5clang12ContinueStmtE")
  //</editor-fold>
  public Stmt /*P*/ RewriteContinueStmt(ContinueStmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteCastExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4729,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteCastExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC15RewriteCastExprEPN5clang14CStyleCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC15RewriteCastExprEPN5clang14CStyleCastExprE")
  //</editor-fold>
  public void RewriteCastExpr(CStyleCastExpr /*P*/ CE) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteImplicitCastObjCExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4767,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteImplicitCastObjCExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteImplicitCastObjCExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteImplicitCastObjCExprEPN5clang8CastExprE")
  //</editor-fold>
  public void RewriteImplicitCastObjCExpr(CastExpr /*P*/ IC) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Computes ivar bitfield group no.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::ObjCIvarBitfieldGroupNo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3767,
   FQN="(anonymous namespace)::RewriteModernObjC::ObjCIvarBitfieldGroupNo", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23ObjCIvarBitfieldGroupNoEPN5clang12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23ObjCIvarBitfieldGroupNoEPN5clang12ObjCIvarDeclE")
  //</editor-fold>
  public /*uint*/int ObjCIvarBitfieldGroupNo(ObjCIvarDecl /*P*/ IV) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Names field decl. for ivar bitfield group.
  
  /// ObjCIvarBitfieldGroupDecl - Names field decl. for ivar bitfield group.
  /// Name would be: classname__GRBF_n where n is the group number for this ivar.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::ObjCIvarBitfieldGroupDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3848,
   FQN="(anonymous namespace)::RewriteModernObjC::ObjCIvarBitfieldGroupDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25ObjCIvarBitfieldGroupDeclEPN5clang12ObjCIvarDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25ObjCIvarBitfieldGroupDeclEPN5clang12ObjCIvarDeclERSs")
  //</editor-fold>
  public void ObjCIvarBitfieldGroupDecl(ObjCIvarDecl /*P*/ IV, 
                           std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Names struct type for ivar bitfield group.
  
  /// ObjCIvarBitfieldGroupType - Names struct type for ivar bitfield group.
  /// Name of the struct would be: classname__T_n where n is the group number for
  /// this ivar.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::ObjCIvarBitfieldGroupType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3860,
   FQN="(anonymous namespace)::RewriteModernObjC::ObjCIvarBitfieldGroupType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25ObjCIvarBitfieldGroupTypeEPN5clang12ObjCIvarDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25ObjCIvarBitfieldGroupTypeEPN5clang12ObjCIvarDeclERSs")
  //</editor-fold>
  public void ObjCIvarBitfieldGroupType(ObjCIvarDecl /*P*/ IV, 
                           std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Names symbol for ivar bitfield group field offset.
  
  /// ObjCIvarBitfieldGroupOffset - Names symbol for ivar bitfield group field offset.
  /// Name would be: OBJC_IVAR_$_classname__GRBF_n where n is the group number for
  /// this ivar.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::ObjCIvarBitfieldGroupOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3872,
   FQN="(anonymous namespace)::RewriteModernObjC::ObjCIvarBitfieldGroupOffset", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27ObjCIvarBitfieldGroupOffsetEPN5clang12ObjCIvarDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27ObjCIvarBitfieldGroupOffsetEPN5clang12ObjCIvarDeclERSs")
  //</editor-fold>
  public void ObjCIvarBitfieldGroupOffset(ObjCIvarDecl /*P*/ IV, 
                             std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Given an ivar bitfield, it builds (or finds) its group record type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::GetGroupRecordTypeForObjCIvarBitfield">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3812,
   FQN="(anonymous namespace)::RewriteModernObjC::GetGroupRecordTypeForObjCIvarBitfield", NM="_ZN12_GLOBAL__N_117RewriteModernObjC37GetGroupRecordTypeForObjCIvarBitfieldEPN5clang12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC37GetGroupRecordTypeForObjCIvarBitfieldEPN5clang12ObjCIvarDeclE")
  //</editor-fold>
  public QualType GetGroupRecordTypeForObjCIvarBitfield(ObjCIvarDecl /*P*/ IV) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthesizeBitfieldGroupStructType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3791,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthesizeBitfieldGroupStructType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC33SynthesizeBitfieldGroupStructTypeEPN5clang12ObjCIvarDeclERN4llvm15SmallVectorImplIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC33SynthesizeBitfieldGroupStructTypeEPN5clang12ObjCIvarDeclERN4llvm15SmallVectorImplIS3_EE")
  //</editor-fold>
  public QualType SynthesizeBitfieldGroupStructType(ObjCIvarDecl /*P*/ IV, 
                                   SmallVectorImpl<ObjCIvarDecl /*P*/ > /*&*/ IVars) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Block rewriting.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteBlocksInFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 608,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteBlocksInFunctionProtoType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC32RewriteBlocksInFunctionProtoTypeEN5clang8QualTypeEPNS1_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC32RewriteBlocksInFunctionProtoTypeEN5clang8QualTypeEPNS1_9NamedDeclE")
  //</editor-fold>
  public void RewriteBlocksInFunctionProtoType(QualType funcType, 
                                  NamedDecl /*P*/ D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Block specific rewrite rules.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteBlockPointerDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4878,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteBlockPointerDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteBlockPointerDeclEPN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteBlockPointerDeclEPN5clang9NamedDeclE")
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteByRefVar">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5027,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteByRefVar", NM="_ZN12_GLOBAL__N_117RewriteModernObjC15RewriteByRefVarEPN5clang7VarDeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC15RewriteByRefVarEPN5clang7VarDeclEbb")
  //</editor-fold>
  public void RewriteByRefVar(VarDecl /*P*/ ND, boolean firstDecl, 
                 boolean lastDecl) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // We need to return the rewritten expression to handle cases where the
  // DeclRefExpr is embedded in another expression being rewritten.
  // For example:
  //
  // int main() {
  //    __block Foo *f;
  //    __block int i;
  //
  //    void (^myblock)() = ^() {
  //        [f test]; // f is a DeclRefExpr embedded in a message (which is being rewritten).
  //        i = 77;
  //    };
  //}
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteBlockDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4676,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteBlockDeclRefExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteBlockDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23RewriteBlockDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteBlockDeclRefExpr(DeclRefExpr /*P*/ DeclRefExp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Rewrites the imported local variable V with external storage 
  // (static, extern, etc.) as *V
  //
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteLocalVariableExternalStorage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4714,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteLocalVariableExternalStorage", NM="_ZN12_GLOBAL__N_117RewriteModernObjC35RewriteLocalVariableExternalStorageEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC35RewriteLocalVariableExternalStorageEPN5clang11DeclRefExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteLocalVariableExternalStorage(DeclRefExpr /*P*/ DRE) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteBlockPointerFunctionArgs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4782,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteBlockPointerFunctionArgs", NM="_ZN12_GLOBAL__N_117RewriteModernObjC31RewriteBlockPointerFunctionArgsEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC31RewriteBlockPointerFunctionArgsEPN5clang12FunctionDeclE")
  //</editor-fold>
  public void RewriteBlockPointerFunctionArgs(FunctionDecl /*P*/ FD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// RewriteObjCInternalStruct - Rewrite one internal struct corresponding to
  /// an objective-c class with ivars.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCInternalStruct">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3887,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCInternalStruct", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25RewriteObjCInternalStructEPN5clang17ObjCInterfaceDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25RewriteObjCInternalStructEPN5clang17ObjCInterfaceDeclERSs")
  //</editor-fold>
  public void RewriteObjCInternalStruct(ObjCInterfaceDecl /*P*/ CDecl, 
                           std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// RewriteObjCFieldDecl - This routine rewrites a field into the buffer.
  /// It handles elaborated types, as well as enum types in the process.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCFieldDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3705,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCFieldDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteObjCFieldDeclEPN5clang9FieldDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC20RewriteObjCFieldDeclEPN5clang9FieldDeclERSs")
  //</editor-fold>
  public void RewriteObjCFieldDecl(FieldDecl /*P*/ fieldDecl, 
                      std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// IsTagDefinedInsideClass - This routine checks that a named tagged type 
  /// is defined inside an objective-c class. If so, it returns true. 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::IsTagDefinedInsideClass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3612,
   FQN="(anonymous namespace)::RewriteModernObjC::IsTagDefinedInsideClass", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23IsTagDefinedInsideClassEPN5clang17ObjCContainerDeclEPNS1_7TagDeclERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23IsTagDefinedInsideClassEPN5clang17ObjCContainerDeclEPNS1_7TagDeclERb")
  //</editor-fold>
  public boolean IsTagDefinedInsideClass(ObjCContainerDecl /*P*/ IDecl, 
                         TagDecl /*P*/ Tag, 
                         bool$ref/*bool &*/ IsNamedDefinition) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteLocallyDefinedNamedAggregates - This routine rewrites locally defined
  /// named aggregate types into the input buffer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteLocallyDefinedNamedAggregates">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3735,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteLocallyDefinedNamedAggregates", NM="_ZN12_GLOBAL__N_117RewriteModernObjC36RewriteLocallyDefinedNamedAggregatesEPN5clang9FieldDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC36RewriteLocallyDefinedNamedAggregatesEPN5clang9FieldDeclERSs")
  //</editor-fold>
  public void RewriteLocallyDefinedNamedAggregates(FieldDecl /*P*/ fieldDecl, 
                                      std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// RewriteObjCFieldDeclType - This routine rewrites a type into the buffer.
  /// It handles elaborated types, as well as enum types in the process.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCFieldDeclType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3640,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCFieldDeclType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteObjCFieldDeclTypeERN5clang8QualTypeERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteObjCFieldDeclTypeERN5clang8QualTypeERSs")
  //</editor-fold>
  public boolean RewriteObjCFieldDeclType(QualType /*&*/ Type, 
                          std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// RewriteIvarOffsetSymbols - Rewrite ivar offset symbols of those ivars which
  /// have been referenced in an ivar access expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteIvarOffsetSymbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3964,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteIvarOffsetSymbols", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteIvarOffsetSymbolsEPN5clang17ObjCInterfaceDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteIvarOffsetSymbolsEPN5clang17ObjCInterfaceDeclERSs")
  //</editor-fold>
  public void RewriteIvarOffsetSymbols(ObjCInterfaceDecl /*P*/ CDecl, 
                          std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::Initialize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5901,
   FQN="(anonymous namespace)::RewriteModernObjC::Initialize", NM="_ZN12_GLOBAL__N_117RewriteModernObjC10InitializeERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC10InitializeERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void Initialize(ASTContext /*&*/ context)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Misc. AST transformation routines. Sometimes they end up calling
  // rewriting routines on the new ASTs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthesizeCallToFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2090,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthesizeCallToFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC28SynthesizeCallToFunctionDeclEPN5clang12FunctionDeclEN4llvm8ArrayRefIPNS1_4ExprEEENS1_14SourceLocationES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC28SynthesizeCallToFunctionDeclEPN5clang12FunctionDeclEN4llvm8ArrayRefIPNS1_4ExprEEENS1_14SourceLocationES9_")
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

  
  
  /// SynthMsgSendStretCallExpr - This routine translates message expression
  /// into a call to objc_msgSend_stret() entry point. Tricky part is that
  /// nil check on receiver must be performed before calling objc_msgSend_stret.
  /// MsgSendStretFlavor - function declaration objc_msgSend_stret(...)
  /// msgSendType - function type of objc_msgSend_stret(...)
  /// returnType - Result type of the method being synthesized.
  /// ArgTypes - type of the arguments passed to objc_msgSend_stret, starting with receiver type.
  /// MsgExprs - list of argument expressions being passed to objc_msgSend_stret, 
  /// starting with receiver.
  /// Method - Method being rewritten.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthMsgSendStretCallExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3096,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthMsgSendStretCallExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25SynthMsgSendStretCallExprEPN5clang12FunctionDeclENS1_8QualTypeERN4llvm15SmallVectorImplIS4_EERNS6_IPNS1_4ExprEEEPNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25SynthMsgSendStretCallExprEPN5clang12FunctionDeclENS1_8QualTypeERN4llvm15SmallVectorImplIS4_EERNS6_IPNS1_4ExprEEEPNS1_14ObjCMethodDeclE")
  //</editor-fold>
  public Expr /*P*/ SynthMsgSendStretCallExpr(FunctionDecl /*P*/ MsgSendStretFlavor, 
                           QualType returnType, 
                           SmallVectorImpl<QualType> /*&*/ ArgTypes, 
                           SmallVectorImpl<Expr /*P*/ > /*&*/ MsgExprs, 
                           ObjCMethodDecl /*P*/ Method) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthMessageExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3200,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthMessageExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC16SynthMessageExprEPN5clang15ObjCMessageExprENS1_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC16SynthMessageExprEPN5clang15ObjCMessageExprENS1_14SourceLocationES4_")
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
  /// ((NSUInteger (*)
  ///  (id, SEL, struct __objcFastEnumerationState *, id *, NSUInteger))
  ///  (void *)objc_msgSend)((id)l_collection,
  ///                        sel_registerName(
  ///                          "countByEnumeratingWithState:objects:count:"),
  ///                        &enumState,
  ///                        (id *)__rw_items, (NSUInteger)16)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthCountByEnumWithState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1590,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthCountByEnumWithState", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25SynthCountByEnumWithStateERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25SynthCountByEnumWithStateERSs")
  //</editor-fold>
  public void SynthCountByEnumWithState(std.string/*&*/ buf) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendFunctionDecl - id objc_msgSend(id self, SEL op, ...);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthMsgSendFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2424,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthMsgSendFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24SynthMsgSendFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24SynthMsgSendFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendSuperFunctionDecl - id objc_msgSendSuper(void);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthMsgSendSuperFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2443,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthMsgSendSuperFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC29SynthMsgSendSuperFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC29SynthMsgSendSuperFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendSuperFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendStretFunctionDecl - id objc_msgSend_stret(id self, SEL op, ...);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthMsgSendStretFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2457,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthMsgSendStretFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC29SynthMsgSendStretFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC29SynthMsgSendStretFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendStretFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendFpretFunctionDecl - double objc_msgSend_fpret(id self, SEL op, ...);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthMsgSendFpretFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2493,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthMsgSendFpretFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC29SynthMsgSendFpretFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC29SynthMsgSendFpretFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendFpretFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthMsgSendSuperStretFunctionDecl -
  // id objc_msgSendSuper_stret(void);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthMsgSendSuperStretFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2477,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthMsgSendSuperStretFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC34SynthMsgSendSuperStretFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC34SynthMsgSendSuperStretFunctionDeclEv")
  //</editor-fold>
  public void SynthMsgSendSuperStretFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthGetClassFunctionDecl - Class objc_getClass(const char *name);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthGetClassFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2512,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthGetClassFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25SynthGetClassFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25SynthGetClassFunctionDeclEv")
  //</editor-fold>
  public void SynthGetClassFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthGetMetaClassFunctionDecl - Class objc_getMetaClass(const char *name);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthGetMetaClassFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2542,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthGetMetaClassFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC29SynthGetMetaClassFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC29SynthGetMetaClassFunctionDeclEv")
  //</editor-fold>
  public void SynthGetMetaClassFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthGetSuperClassFunctionDecl - Class class_getSuperclass(Class cls);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthGetSuperClassFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2526,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthGetSuperClassFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC30SynthGetSuperClassFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC30SynthGetSuperClassFunctionDeclEv")
  //</editor-fold>
  public void SynthGetSuperClassFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthSelGetUidFunctionDecl - SEL sel_registerName(const char *str);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthSelGetUidFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2312,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthSelGetUidFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC26SynthSelGetUidFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC26SynthSelGetUidFunctionDeclEv")
  //</editor-fold>
  public void SynthSelGetUidFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // SynthSuperConstructorFunctionDecl - id __rw_objc_super(id obj, id super);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthSuperConstructorFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2405,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthSuperConstructorFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC33SynthSuperConstructorFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC33SynthSuperConstructorFunctionDeclEv")
  //</editor-fold>
  public void SynthSuperConstructorFunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Rewriting metadata
  /*template <typename MethodIterator> TEMPLATE*/
  
  // RewriteObjCMethodsMetaData - Rewrite methods metadata for instance or
  /// class methods.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCMethodsMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 7377,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCMethodsMetaData", NM="Tpl__ZN12_GLOBAL__N_117RewriteModernObjC26RewriteObjCMethodsMetaDataET_S1_bN4llvm9StringRefES3_RSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=Tpl__ZN12_GLOBAL__N_117RewriteModernObjC26RewriteObjCMethodsMetaDataET_S1_bN4llvm9StringRefES3_RSs")
  //</editor-fold>
  public </*typename*/ MethodIterator> void RewriteObjCMethodsMetaData(MethodIterator MethodBegin, 
                            MethodIterator MethodEnd, 
                            boolean IsInstanceMethod, 
                            StringRef prefix, 
                            StringRef ClassName, 
                            std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteObjCProtocolMetaData - Rewrite protocols meta-data.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCProtocolMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6853,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCProtocolMetaData", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteObjCProtocolMetaDataEPN5clang16ObjCProtocolDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteObjCProtocolMetaDataEPN5clang16ObjCProtocolDeclERSs")
  //</editor-fold>
  public void RewriteObjCProtocolMetaData(ObjCProtocolDecl /*P*/ PDecl, 
                             std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCClassMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 7015,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCClassMetaData", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteObjCClassMetaDataEPN5clang22ObjCImplementationDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24RewriteObjCClassMetaDataEPN5clang22ObjCImplementationDeclERSs")
  //</editor-fold>
  public void RewriteObjCClassMetaData(ObjCImplementationDecl /*P*/ IDecl, 
                          std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteClassSetupInitHook">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 7172,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteClassSetupInitHook", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25RewriteClassSetupInitHookERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25RewriteClassSetupInitHookERSs")
  //</editor-fold>
  public void RewriteClassSetupInitHook(std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteMetaDataIntoBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 7188,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteMetaDataIntoBuffer", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25RewriteMetaDataIntoBufferERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25RewriteMetaDataIntoBufferERSs")
  //</editor-fold>
  public void RewriteMetaDataIntoBuffer(std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::WriteImageInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 7266,
   FQN="(anonymous namespace)::RewriteModernObjC::WriteImageInfo", NM="_ZN12_GLOBAL__N_117RewriteModernObjC14WriteImageInfoERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC14WriteImageInfoERSs")
  //</editor-fold>
  public void WriteImageInfo(std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteObjCCategoryImplDecl - Rewrite metadata for each category
  /// implementation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 7277,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCCategoryImplDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteObjCCategoryImplDeclEPN5clang20ObjCCategoryImplDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27RewriteObjCCategoryImplDeclEPN5clang20ObjCCategoryImplDeclERSs")
  //</editor-fold>
  public void RewriteObjCCategoryImplDecl(ObjCCategoryImplDecl /*P*/ IDecl, 
                             std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteCategorySetupInitHook">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 7354,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteCategorySetupInitHook", NM="_ZN12_GLOBAL__N_117RewriteModernObjC28RewriteCategorySetupInitHookERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC28RewriteCategorySetupInitHookERSs")
  //</editor-fold>
  public void RewriteCategorySetupInitHook(std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Rewriting ivar
  
  /// RewriteIvarOffsetComputation - This rutine synthesizes computation of
  /// ivar offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteIvarOffsetComputation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6075,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteIvarOffsetComputation", NM="_ZN12_GLOBAL__N_117RewriteModernObjC28RewriteIvarOffsetComputationEPN5clang12ObjCIvarDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC28RewriteIvarOffsetComputationEPN5clang12ObjCIvarDeclERSs")
  //</editor-fold>
  public void RewriteIvarOffsetComputation(ObjCIvarDecl /*P*/ ivar, 
                              std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::RewriteObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 7455,
   FQN="(anonymous namespace)::RewriteModernObjC::RewriteObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC22RewriteObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC22RewriteObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public Stmt /*P*/ RewriteObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ IV) {
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthesizeByrefCopyDestroyHelper">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4972,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthesizeByrefCopyDestroyHelper", NM="_ZN12_GLOBAL__N_117RewriteModernObjC32SynthesizeByrefCopyDestroyHelperEPN5clang7VarDeclEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC32SynthesizeByrefCopyDestroyHelperEPN5clang7VarDeclEi")
  //</editor-fold>
  public std.string SynthesizeByrefCopyDestroyHelper(VarDecl /*P*/ VD, 
                                  int flag) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockHelperFuncs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4145,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockHelperFuncs", NM="_ZN12_GLOBAL__N_117RewriteModernObjC26SynthesizeBlockHelperFuncsEPN5clang9BlockExprEiN4llvm9StringRefESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC26SynthesizeBlockHelperFuncsEPN5clang9BlockExprEiN4llvm9StringRefESs")
  //</editor-fold>
  public std.string SynthesizeBlockHelperFuncs(BlockExpr /*P*/ CE, int i, 
                            StringRef funcName, 
                            std.string Tag) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockFunc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4049,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockFunc", NM="_ZN12_GLOBAL__N_117RewriteModernObjC19SynthesizeBlockFuncEPN5clang9BlockExprEiN4llvm9StringRefESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC19SynthesizeBlockFuncEPN5clang9BlockExprEiN4llvm9StringRefESs")
  //</editor-fold>
  public std.string SynthesizeBlockFunc(BlockExpr /*P*/ CE, int i, 
                     StringRef funcName, 
                     std.string Tag) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4189,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockImpl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC19SynthesizeBlockImplEPN5clang9BlockExprESsSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC19SynthesizeBlockImplEPN5clang9BlockExprESsSs")
  //</editor-fold>
  public std.string SynthesizeBlockImpl(BlockExpr /*P*/ CE, std.string Tag, 
                     std.string Desc) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4304,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockDescriptor", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25SynthesizeBlockDescriptorESsSsiN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25SynthesizeBlockDescriptorESsSsiN4llvm9StringRefEj")
  //</editor-fold>
  public std.string SynthesizeBlockDescriptor(std.string DescTag, 
                           std.string ImplTag, int i, 
                           StringRef FunName, 
                           /*uint*/int hasCopy) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockCall">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4562,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockCall", NM="_ZN12_GLOBAL__N_117RewriteModernObjC19SynthesizeBlockCallEPN5clang8CallExprEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC19SynthesizeBlockCallEPN5clang8CallExprEPKNS1_4ExprE")
  //</editor-fold>
  public Stmt /*P*/ SynthesizeBlockCall(CallExpr /*P*/ Exp, /*const*/ Expr /*P*/ BlockExp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockLiterals">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4332,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthesizeBlockLiterals", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23SynthesizeBlockLiteralsEN5clang14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23SynthesizeBlockLiteralsEN5clang14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public void SynthesizeBlockLiterals(SourceLocation FunLocStart, 
                         StringRef FunName) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthBlockInitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5203,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthBlockInitFunctionDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC26SynthBlockInitFunctionDeclEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC26SynthBlockInitFunctionDeclEN4llvm9StringRefE")
  //</editor-fold>
  public FunctionDecl /*P*/ SynthBlockInitFunctionDecl(StringRef name) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::SynthBlockInitExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5211,
   FQN="(anonymous namespace)::RewriteModernObjC::SynthBlockInitExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC18SynthBlockInitExprEPN5clang9BlockExprERKN4llvm15SmallVectorImplIPNS1_11DeclRefExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC18SynthBlockInitExprEPN5clang9BlockExprERKN4llvm15SmallVectorImplIPNS1_11DeclRefExprEEE")
  //</editor-fold>
  public Stmt /*P*/ SynthBlockInitExpr(BlockExpr /*P*/ Exp, 
                    /*const*/ SmallVectorImpl<DeclRefExpr /*P*/ > /*&*/ InnerBlockDeclRefs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Misc. helper routines.
  
  // typedef struct objc_object Protocol;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::getProtocolType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3576,
   FQN="(anonymous namespace)::RewriteModernObjC::getProtocolType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC15getProtocolTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC15getProtocolTypeEv")
  //</editor-fold>
  public QualType getProtocolType() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::WarnAboutReturnGotoStmts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1909,
   FQN="(anonymous namespace)::RewriteModernObjC::WarnAboutReturnGotoStmts", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24WarnAboutReturnGotoStmtsEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24WarnAboutReturnGotoStmtsEPN5clang4StmtE")
  //</editor-fold>
  public void WarnAboutReturnGotoStmts(Stmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::CheckFunctionPointerDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 621,
   FQN="(anonymous namespace)::RewriteModernObjC::CheckFunctionPointerDecl", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24CheckFunctionPointerDeclEN5clang8QualTypeEPNS1_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24CheckFunctionPointerDeclEN5clang8QualTypeEPNS1_9NamedDeclE")
  //</editor-fold>
  public void CheckFunctionPointerDecl(QualType funcType, NamedDecl /*P*/ ND) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::InsertBlockLiteralsWithinFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4441,
   FQN="(anonymous namespace)::RewriteModernObjC::InsertBlockLiteralsWithinFunction", NM="_ZN12_GLOBAL__N_117RewriteModernObjC33InsertBlockLiteralsWithinFunctionEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC33InsertBlockLiteralsWithinFunctionEPN5clang12FunctionDeclE")
  //</editor-fold>
  public void InsertBlockLiteralsWithinFunction(FunctionDecl /*P*/ FD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::InsertBlockLiteralsWithinMethod">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4461,
   FQN="(anonymous namespace)::RewriteModernObjC::InsertBlockLiteralsWithinMethod", NM="_ZN12_GLOBAL__N_117RewriteModernObjC31InsertBlockLiteralsWithinMethodEPN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC31InsertBlockLiteralsWithinMethodEPN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public void InsertBlockLiteralsWithinMethod(ObjCMethodDecl /*P*/ MD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::IsDeclStmtInForeachHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5433,
   FQN="(anonymous namespace)::RewriteModernObjC::IsDeclStmtInForeachHeader", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25IsDeclStmtInForeachHeaderEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25IsDeclStmtInForeachHeaderEPN5clang8DeclStmtE")
  //</editor-fold>
  public boolean IsDeclStmtInForeachHeader(DeclStmt /*P*/ DS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::CollectBlockDeclRefInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5174,
   FQN="(anonymous namespace)::RewriteModernObjC::CollectBlockDeclRefInfo", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23CollectBlockDeclRefInfoEPN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23CollectBlockDeclRefInfoEPN5clang9BlockExprE")
  //</editor-fold>
  public void CollectBlockDeclRefInfo(BlockExpr /*P*/ Exp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::GetBlockDeclRefExprs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4470,
   FQN="(anonymous namespace)::RewriteModernObjC::GetBlockDeclRefExprs", NM="_ZN12_GLOBAL__N_117RewriteModernObjC20GetBlockDeclRefExprsEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC20GetBlockDeclRefExprsEPN5clang4StmtE")
  //</editor-fold>
  public void GetBlockDeclRefExprs(Stmt /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::GetInnerBlockDeclRefExprs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4486,
   FQN="(anonymous namespace)::RewriteModernObjC::GetInnerBlockDeclRefExprs", NM="_ZN12_GLOBAL__N_117RewriteModernObjC25GetInnerBlockDeclRefExprsEPN5clang4StmtERN4llvm15SmallVectorImplIPNS1_11DeclRefExprEEERNS4_15SmallPtrSetImplIPKNS1_11DeclContextEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC25GetInnerBlockDeclRefExprsEPN5clang4StmtERN4llvm15SmallVectorImplIPNS1_11DeclRefExprEEERNS4_15SmallPtrSetImplIPKNS1_11DeclContextEEE")
  //</editor-fold>
  public void GetInnerBlockDeclRefExprs(Stmt /*P*/ S, 
                           SmallVectorImpl<DeclRefExpr /*P*/ > /*&*/ InnerBlockDeclRefs, 
                           SmallPtrSetImpl</*const*/ DeclContext /*P*/ > /*&*/ InnerContexts) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // We avoid calling Type::isBlockPointerType(), since it operates on the
  // canonical type. We only care if the top-level type is a closure pointer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::isTopLevelBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 499,
   FQN="(anonymous namespace)::RewriteModernObjC::isTopLevelBlockPointerType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC26isTopLevelBlockPointerTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC26isTopLevelBlockPointerTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isTopLevelBlockPointerType(QualType T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// convertBlockPointerToFunctionPointer - Converts a block-pointer type
  /// to a function pointer type and upon success, returns true; false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::convertBlockPointerToFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 506,
   FQN="(anonymous namespace)::RewriteModernObjC::convertBlockPointerToFunctionPointer", NM="_ZN12_GLOBAL__N_117RewriteModernObjC36convertBlockPointerToFunctionPointerERN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC36convertBlockPointerToFunctionPointerERN5clang8QualTypeE")
  //</editor-fold>
  public boolean convertBlockPointerToFunctionPointer(QualType /*&*/ T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// convertObjCTypeToCStyleType - This routine converts such objc types
  /// as qualified objects, and blocks to their closest c/c++ types that
  /// it can. It returns true if input type was modified.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::convertObjCTypeToCStyleType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4516,
   FQN="(anonymous namespace)::RewriteModernObjC::convertObjCTypeToCStyleType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27convertObjCTypeToCStyleTypeERN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27convertObjCTypeToCStyleTypeERN5clang8QualTypeE")
  //</editor-fold>
  public boolean convertObjCTypeToCStyleType(QualType /*&*/ T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::needToScanForQualifiers">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2145,
   FQN="(anonymous namespace)::RewriteModernObjC::needToScanForQualifiers", NM="_ZN12_GLOBAL__N_117RewriteModernObjC23needToScanForQualifiersEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC23needToScanForQualifiersEN5clang8QualTypeE")
  //</editor-fold>
  public boolean needToScanForQualifiers(QualType T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // struct __rw_objc_super { 
  //   struct objc_object *object; struct objc_object *superClass; 
  // };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::getSuperStructType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2980,
   FQN="(anonymous namespace)::RewriteModernObjC::getSuperStructType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC18getSuperStructTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC18getSuperStructTypeEv")
  //</editor-fold>
  public QualType getSuperStructType() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::getConstantStringStructType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3008,
   FQN="(anonymous namespace)::RewriteModernObjC::getConstantStringStructType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27getConstantStringStructTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27getConstantStringStructTypeEv")
  //</editor-fold>
  public QualType getConstantStringStructType() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// convertFunctionTypeOfBlocks - This routine converts a function type
  /// whose result type may be a block pointer or whose argument type(s)
  /// might be block pointers to an equivalent function type replacing
  /// all block pointers to function pointers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::convertFunctionTypeOfBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4538,
   FQN="(anonymous namespace)::RewriteModernObjC::convertFunctionTypeOfBlocks", NM="_ZN12_GLOBAL__N_117RewriteModernObjC27convertFunctionTypeOfBlocksEPKN5clang12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC27convertFunctionTypeOfBlocksEPKN5clang12FunctionTypeE")
  //</editor-fold>
  public QualType convertFunctionTypeOfBlocks(/*const*/ FunctionType /*P*/ FT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::convertToUnqualifiedObjCType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 522,
   FQN="(anonymous namespace)::RewriteModernObjC::convertToUnqualifiedObjCType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC28convertToUnqualifiedObjCTypeERN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC28convertToUnqualifiedObjCTypeERN5clang8QualTypeE")
  //</editor-fold>
  public void convertToUnqualifiedObjCType(QualType /*&*/ T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // FIXME: This predicate seems like it would be useful to add to ASTContext.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::isObjCType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 542,
   FQN="(anonymous namespace)::RewriteModernObjC::isObjCType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC10isObjCTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC10isObjCTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isObjCType(QualType T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::PointerTypeTakesAnyBlockArguments">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4816,
   FQN="(anonymous namespace)::RewriteModernObjC::PointerTypeTakesAnyBlockArguments", NM="_ZN12_GLOBAL__N_117RewriteModernObjC33PointerTypeTakesAnyBlockArgumentsEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC33PointerTypeTakesAnyBlockArgumentsEN5clang8QualTypeE")
  //</editor-fold>
  public boolean PointerTypeTakesAnyBlockArguments(QualType QT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::PointerTypeTakesAnyObjCQualifiedType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4834,
   FQN="(anonymous namespace)::RewriteModernObjC::PointerTypeTakesAnyObjCQualifiedType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC36PointerTypeTakesAnyObjCQualifiedTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC36PointerTypeTakesAnyObjCQualifiedTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean PointerTypeTakesAnyObjCQualifiedType(QualType QT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::GetExtentOfArgList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4857,
   FQN="(anonymous namespace)::RewriteModernObjC::GetExtentOfArgList", NM="_ZN12_GLOBAL__N_117RewriteModernObjC18GetExtentOfArgListEPKcRS2_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC18GetExtentOfArgListEPKcRS2_S3_")
  //</editor-fold>
  public void GetExtentOfArgList(/*const*/char$ptr/*char P*/ Name, char$ptr/*const char P &*/ LParen, 
                    char$ptr/*const char P &*/ RParen) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::QuoteDoublequotes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 565,
   FQN="(anonymous namespace)::RewriteModernObjC::QuoteDoublequotes", NM="_ZN12_GLOBAL__N_117RewriteModernObjC17QuoteDoublequotesERSsS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC17QuoteDoublequotesERSsS1_")
  //</editor-fold>
  public void QuoteDoublequotes(std.string/*&*/ From, std.string/*&*/ To) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::getSimpleFunctionType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 574,
   FQN="(anonymous namespace)::RewriteModernObjC::getSimpleFunctionType", NM="_ZN12_GLOBAL__N_117RewriteModernObjC21getSimpleFunctionTypeEN5clang8QualTypeEN4llvm8ArrayRefIS2_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC21getSimpleFunctionTypeEN5clang8QualTypeEN4llvm8ArrayRefIS2_EEb")
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::NoTypeInfoCStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 585,
   FQN="(anonymous namespace)::RewriteModernObjC::NoTypeInfoCStyleCastExpr", NM="_ZN12_GLOBAL__N_117RewriteModernObjC24NoTypeInfoCStyleCastExprEPN5clang10ASTContextENS1_8QualTypeENS1_8CastKindEPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC24NoTypeInfoCStyleCastExprEPN5clang10ASTContextENS1_8QualTypeENS1_8CastKindEPNS1_4ExprE")
  //</editor-fold>
  public CStyleCastExpr /*P*/ NoTypeInfoCStyleCastExpr(ASTContext /*P*/ Ctx, QualType Ty, 
                          CastKind Kind, Expr /*P*/ E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::ImplementationIsNonLazy">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 592,
   FQN="(anonymous namespace)::RewriteModernObjC::ImplementationIsNonLazy", NM="_ZNK12_GLOBAL__N_117RewriteModernObjC23ImplementationIsNonLazyEPKN5clang12ObjCImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZNK12_GLOBAL__N_117RewriteModernObjC23ImplementationIsNonLazyEPKN5clang12ObjCImplDeclE")
  //</editor-fold>
  public boolean ImplementationIsNonLazy(/*const*/ ObjCImplDecl /*P*/ OD) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteModernObjC::getStringLiteral">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 598,
   FQN="(anonymous namespace)::RewriteModernObjC::getStringLiteral", NM="_ZN12_GLOBAL__N_117RewriteModernObjC16getStringLiteralEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN12_GLOBAL__N_117RewriteModernObjC16getStringLiteralEN4llvm9StringRefE")
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
              + ", GlobalConstructionExp=" + GlobalConstructionExp // NOI18N
              + ", RewriteFailedDiag=" + RewriteFailedDiag // NOI18N
              + ", GlobalBlockRewriteFailedDiag=" + GlobalBlockRewriteFailedDiag // NOI18N
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
              + ", ClassImplementation=" + ClassImplementation // NOI18N
              + ", CategoryImplementation=" + CategoryImplementation // NOI18N
              + ", ObjCSynthesizedStructs=" + ObjCSynthesizedStructs // NOI18N
              + ", ObjCSynthesizedProtocols=" + ObjCSynthesizedProtocols // NOI18N
              + ", ObjCWrittenInterfaces=" + ObjCWrittenInterfaces // NOI18N
              + ", GlobalDefinedTags=" + GlobalDefinedTags // NOI18N
              + ", ObjCInterfacesSeen=" + ObjCInterfacesSeen // NOI18N
              + ", DefinedNonLazyClasses=" + DefinedNonLazyClasses // NOI18N
              + ", DefinedNonLazyCategories=" + DefinedNonLazyCategories // NOI18N
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
              + ", ReferencedIvars=" + ReferencedIvars // NOI18N
              + ", ObjCInterefaceHasBitfieldGroups=" + ObjCInterefaceHasBitfieldGroups // NOI18N
              + ", IvarGroupNumber=" + IvarGroupNumber // NOI18N
              + ", GroupRecordType=" + GroupRecordType // NOI18N
              + ", FunctionDefinitionsSeen=" + FunctionDefinitionsSeen // NOI18N
              + ", ReplacedNodes=" + ReplacedNodes // NOI18N
              + ", IsHeader=" + IsHeader // NOI18N
              + ", SilenceRewriteMacroWarning=" + SilenceRewriteMacroWarning // NOI18N
              + ", GenerateLineInfo=" + GenerateLineInfo // NOI18N
              + ", objc_impl_method=" + objc_impl_method // NOI18N
              + ", DisableReplaceStmt=" + DisableReplaceStmt // NOI18N
              + ", MethodInternalNames=" + MethodInternalNames // NOI18N
              + super.toString(); // NOI18N
  }
}
