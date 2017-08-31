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
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.basic.target.*;
import static org.clang.basic.target.TargetCXXABI.*;
import static org.clang.ast.impl.MangleStatics.getCallingConvMangling;


/// MangleContext - Context for tracking state which persists across multiple
/// calls to the C++ name mangler.
//<editor-fold defaultstate="collapsed" desc="clang::MangleContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 42,
 FQN="clang::MangleContext", NM="_ZN5clang13MangleContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContextE")
//</editor-fold>
public abstract class MangleContext implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::ManglerKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 44,
   FQN="clang::MangleContext::ManglerKind", NM="_ZN5clang13MangleContext11ManglerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext11ManglerKindE")
  //</editor-fold>
  public enum ManglerKind implements Native.ComparableLower {
    MK_Itanium(0),
    MK_Microsoft(MK_Itanium.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ManglerKind valueOf(int val) {
      ManglerKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ManglerKind[] VALUES;
      private static final ManglerKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ManglerKind kind : ManglerKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ManglerKind[min < 0 ? (1-min) : 0];
        VALUES = new ManglerKind[max >= 0 ? (1+max) : 0];
        for (ManglerKind kind : ManglerKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ManglerKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ManglerKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ManglerKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 50,
   FQN="clang::MangleContext::anchor", NM="_ZN5clang13MangleContext6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  
  private final ASTContext /*&*/ Context;
  private final DiagnosticsEngine /*&*/ Diags;
  private /*const*/ ManglerKind Kind;
  
  private DenseMapTypeUInt</*const*/ BlockDecl /*P*/ > GlobalBlockIds;
  private DenseMapTypeUInt</*const*/ BlockDecl /*P*/ > LocalBlockIds;
  private DenseMapTypeULong</*const*/ TagDecl /*P*/ > AnonStructIds;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 61,
   FQN="clang::MangleContext::getKind", NM="_ZNK5clang13MangleContext7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZNK5clang13MangleContext7getKindEv")
  //</editor-fold>
  public ManglerKind getKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::MangleContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 63,
   FQN="clang::MangleContext::MangleContext", NM="_ZN5clang13MangleContextC1ERNS_10ASTContextERNS_17DiagnosticsEngineENS0_11ManglerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContextC1ERNS_10ASTContextERNS_17DiagnosticsEngineENS0_11ManglerKindE")
  //</editor-fold>
  public /*explicit*/ MangleContext(final ASTContext /*&*/ Context, 
      final DiagnosticsEngine /*&*/ Diags, 
      ManglerKind Kind) {
    // : Context(Context), Diags(Diags), Kind(Kind), GlobalBlockIds(), LocalBlockIds(), AnonStructIds() 
    //START JInit
    this./*&*/Context=/*&*/Context;
    this./*&*/Diags=/*&*/Diags;
    this.Kind = Kind;
    this.GlobalBlockIds = new DenseMapTypeUInt</*const*/ BlockDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.LocalBlockIds = new DenseMapTypeUInt</*const*/ BlockDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.AnonStructIds = new DenseMapTypeULong</*const*/ TagDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::~MangleContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 68,
   FQN="clang::MangleContext::~MangleContext", NM="_ZN5clang13MangleContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContextD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    AnonStructIds.$destroy();
    LocalBlockIds.$destroy();
    GlobalBlockIds.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 70,
   FQN="clang::MangleContext::getASTContext", NM="_ZNK5clang13MangleContext13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZNK5clang13MangleContext13getASTContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getASTContext() /*const*/ {
    return Context;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::getDiags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 72,
   FQN="clang::MangleContext::getDiags", NM="_ZNK5clang13MangleContext8getDiagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZNK5clang13MangleContext8getDiagsEv")
  //</editor-fold>
  public DiagnosticsEngine /*&*/ getDiags() /*const*/ {
    return Diags;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::startNewFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 74,
   FQN="clang::MangleContext::startNewFunction", NM="_ZN5clang13MangleContext16startNewFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext16startNewFunctionEv")
  //</editor-fold>
  public /*virtual*/ void startNewFunction() {
    LocalBlockIds.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::getBlockId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 76,
   FQN="clang::MangleContext::getBlockId", NM="_ZN5clang13MangleContext10getBlockIdEPKNS_9BlockDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext10getBlockIdEPKNS_9BlockDeclEb")
  //</editor-fold>
  public /*uint*/int getBlockId(/*const*/ BlockDecl /*P*/ BD, boolean Local) {
    final DenseMapTypeUInt</*const*/ BlockDecl /*P*/ > /*&*/ BlockIds = Local ? LocalBlockIds : GlobalBlockIds;
    std.pairTypeBool<DenseMapIteratorTypeUInt</*const*/ BlockDecl /*P*/ /*P*/>> Result = BlockIds.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint(BD, BlockIds.size()));
    return Result.first.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::getAnonymousStructId">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 84,
   FQN="clang::MangleContext::getAnonymousStructId", NM="_ZN5clang13MangleContext20getAnonymousStructIdEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext20getAnonymousStructIdEPKNS_7TagDeclE")
  //</editor-fold>
  public long/*uint64_t*/ getAnonymousStructId(/*const*/ TagDecl /*P*/ TD) {
    std.pairTypeBool<DenseMapIteratorTypeULong</*const*/ TagDecl /*P*/ /*P*/>> Result = AnonStructIds.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint2ulong(TD, AnonStructIds.size()));
    return Result.first.$arrow().second;
  }

  
  /// @name Mangler Entry Points
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::shouldMangleDeclName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 98,
   FQN="clang::MangleContext::shouldMangleDeclName", NM="_ZN5clang13MangleContext20shouldMangleDeclNameEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext20shouldMangleDeclNameEPKNS_9NamedDeclE")
  //</editor-fold>
  public boolean shouldMangleDeclName(/*const*/ NamedDecl /*P*/ D) {
    final /*const*/ ASTContext /*&*/ $ASTContext = getASTContext();
    
    CCMangling CC = getCallingConvMangling($ASTContext, D);
    if (CC != CCMangling.CCM_Other) {
      return true;
    }
    
    // In C, functions with no attributes never need to be mangled. Fastpath them.
    if (!getASTContext().getLangOpts().CPlusPlus && !D.hasAttrs()) {
      return false;
    }
    
    // Any decl can be declared with __asm("foo") on it, and this takes precedence
    // over all other naming in the .o file.
    if (D.hasAttr(AsmLabelAttr.class)) {
      return true;
    }
    
    return shouldMangleCXXName(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::shouldMangleCXXName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 94,
   FQN="clang::MangleContext::shouldMangleCXXName", NM="_ZN5clang13MangleContext19shouldMangleCXXNameEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext19shouldMangleCXXNameEPKNS_9NamedDeclE")
  //</editor-fold>
  public abstract /*virtual*/ boolean shouldMangleCXXName(/*const*/ NamedDecl /*P*/ D)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::shouldMangleStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 95,
   FQN="clang::MangleContext::shouldMangleStringLiteral", NM="_ZN5clang13MangleContext25shouldMangleStringLiteralEPKNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext25shouldMangleStringLiteralEPKNS_13StringLiteralE")
  //</editor-fold>
  public abstract /*virtual*/ boolean shouldMangleStringLiteral(/*const*/ StringLiteral /*P*/ SL)/* = 0*/;

  
  // FIXME: consider replacing raw_ostream & with something like SmallString &.
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 117,
   FQN="clang::MangleContext::mangleName", NM="_ZN5clang13MangleContext10mangleNameEPKNS_9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext10mangleNameEPKNS_9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void mangleName(/*const*/ NamedDecl /*P*/ D, final raw_ostream /*&*/ Out) {
    {
      // Any decl can be declared with __asm("foo") on it, and this takes precedence
      // over all other naming in the .o file.
      /*const*/ AsmLabelAttr /*P*/ ALA = D.getAttr(AsmLabelAttr.class);
      if ((ALA != null)) {
        // If we have an asm name, then we use it as the mangling.
        
        // Adding the prefix can cause problems when one file has a "foo" and
        // another has a "\01foo". That is known to happen on ELF with the
        // tricks normally used for producing aliases (PR9177). Fortunately the
        // llvm mangler on ELF is a nop, so we can just avoid adding the \01
        // marker.  We also avoid adding the marker if this is an alias for an
        // LLVM intrinsic.
        /*char*/byte GlobalPrefix = getASTContext().getTargetInfo().getDataLayout().getGlobalPrefix();
        if ((GlobalPrefix != 0) && !ALA.getLabel().startswith(/*STRINGREF_STR*/"llvm.")) {
          Out.$out_char($$SOH); // LLVM IR Marker for __asm("foo")
        }
        
        Out.$out(ALA.getLabel());
        return;
      }
    }
    
    final /*const*/ ASTContext /*&*/ $ASTContext = getASTContext();
    CCMangling CC = getCallingConvMangling($ASTContext, D);
    boolean MCXX = shouldMangleCXXName(D);
    final /*const*/ TargetInfo /*&*/ TI = Context.getTargetInfo();
    if (CC == CCMangling.CCM_Other || (MCXX && $eq_TargetCXXABI$C(TI.getCXXABI(), new TargetCXXABI(TargetCXXABI.Kind.Microsoft)))) {
      {
        /*const*/ ObjCMethodDecl /*P*/ OMD = dyn_cast_ObjCMethodDecl(D);
        if ((OMD != null)) {
          mangleObjCMethodName(OMD, Out);
        } else {
          mangleCXXName(D, Out);
        }
      }
      return;
    }
    
    Out.$out_char($$SOH);
    if (CC == CCMangling.CCM_Std) {
      Out.$out_char($$UNDERSCORE);
    } else if (CC == CCMangling.CCM_Fast) {
      Out.$out_char($$AT);
    }
    if (!MCXX) {
      Out.$out(D.getIdentifier().getName());
    } else {
      /*const*/ ObjCMethodDecl /*P*/ OMD = dyn_cast_ObjCMethodDecl(D);
      if ((OMD != null)) {
        mangleObjCMethodName(OMD, Out);
      } else {
        mangleCXXName(D, Out);
      }
    }
    
    /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(D);
    /*const*/ FunctionType /*P*/ FT = FD.getType().$arrow().castAs(FunctionType.class);
    /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_FunctionProtoType(FT);
    if (CC == CCMangling.CCM_Vector) {
      Out.$out_char($$AT);
    }
    Out.$out_char($$AT);
    if (!(Proto != null)) {
      Out.$out_char($$0);
      return;
    }
    assert (!Proto.isVariadic());
    /*uint*/int ArgWords = 0;
    {
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
      if ((MD != null)) {
        if (!MD.isStatic()) {
          ++ArgWords;
        }
      }
    }
    for (final /*const*/ QualType /*&*/ AT : Proto.param_types())  {
      // Size should be aligned to pointer size.
      ArgWords += $div_ulong(llvm.alignTo($ASTContext.getTypeSize(new QualType(AT)), TI.getPointerWidth(0))
        , TI.getPointerWidth(0));
    }
    Out.$out_ullong((($div_ulong_ullong(TI.getPointerWidth(0), $int2ullong(8))) * $uint2ullong(ArgWords)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleCXXName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 99,
   FQN="clang::MangleContext::mangleCXXName", NM="_ZN5clang13MangleContext13mangleCXXNameEPKNS_9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext13mangleCXXNameEPKNS_9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXName(/*const*/ NamedDecl /*P*/ D, final raw_ostream /*&*/ $Prm1)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 100,
   FQN="clang::MangleContext::mangleThunk", NM="_ZN5clang13MangleContext11mangleThunkEPKNS_13CXXMethodDeclERKNS_9ThunkInfoERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext11mangleThunkEPKNS_13CXXMethodDeclERKNS_9ThunkInfoERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleThunk(/*const*/ CXXMethodDecl /*P*/ MD, 
             final /*const*/ ThunkInfo /*&*/ Thunk, 
             final raw_ostream /*&*/ $Prm2)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleCXXDtorThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 103,
   FQN="clang::MangleContext::mangleCXXDtorThunk", NM="_ZN5clang13MangleContext18mangleCXXDtorThunkEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeERKNS_14ThisAdjustmentERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext18mangleCXXDtorThunkEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeERKNS_14ThisAdjustmentERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXDtorThunk(/*const*/ CXXDestructorDecl /*P*/ DD, CXXDtorType Type, 
                    final /*const*/ ThisAdjustment /*&*/ $ThisAdjustment, 
                    final raw_ostream /*&*/ $Prm3)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleReferenceTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 106,
   FQN="clang::MangleContext::mangleReferenceTemporary", NM="_ZN5clang13MangleContext24mangleReferenceTemporaryEPKNS_7VarDeclEjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext24mangleReferenceTemporaryEPKNS_7VarDeclEjRN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleReferenceTemporary(/*const*/ VarDecl /*P*/ D, 
                          /*uint*/int ManglingNumber, 
                          final raw_ostream /*&*/ $Prm2)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleCXXRTTI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 109,
   FQN="clang::MangleContext::mangleCXXRTTI", NM="_ZN5clang13MangleContext13mangleCXXRTTIENS_8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext13mangleCXXRTTIENS_8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXRTTI(QualType T, final raw_ostream /*&*/ $Prm1)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleCXXRTTIName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 110,
   FQN="clang::MangleContext::mangleCXXRTTIName", NM="_ZN5clang13MangleContext17mangleCXXRTTINameENS_8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext17mangleCXXRTTINameENS_8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXRTTIName(QualType T, final raw_ostream /*&*/ $Prm1)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleCXXCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 111,
   FQN="clang::MangleContext::mangleCXXCtor", NM="_ZN5clang13MangleContext13mangleCXXCtorEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext13mangleCXXCtorEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXCtor(/*const*/ CXXConstructorDecl /*P*/ D, CXXCtorType Type, 
               final raw_ostream /*&*/ $Prm2)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleCXXDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 113,
   FQN="clang::MangleContext::mangleCXXDtor", NM="_ZN5clang13MangleContext13mangleCXXDtorEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext13mangleCXXDtorEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXDtor(/*const*/ CXXDestructorDecl /*P*/ D, CXXDtorType Type, 
               final raw_ostream /*&*/ $Prm2)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 115,
   FQN="clang::MangleContext::mangleStringLiteral", NM="_ZN5clang13MangleContext19mangleStringLiteralEPKNS_13StringLiteralERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext19mangleStringLiteralEPKNS_13StringLiteralERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleStringLiteral(/*const*/ StringLiteral /*P*/ SL, final raw_ostream /*&*/ $Prm1)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleGlobalBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 186,
   FQN="clang::MangleContext::mangleGlobalBlock", NM="_ZN5clang13MangleContext17mangleGlobalBlockEPKNS_9BlockDeclEPKNS_9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext17mangleGlobalBlockEPKNS_9BlockDeclEPKNS_9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void mangleGlobalBlock(/*const*/ BlockDecl /*P*/ BD, 
                   /*const*/ NamedDecl /*P*/ ID, 
                   final raw_ostream /*&*/ Out) {
    /*uint*/int discriminator = getBlockId(BD, false);
    if ((ID != null)) {
      if (shouldMangleDeclName(ID)) {
        mangleName(ID, Out);
      } else {
        Out.$out(ID.getIdentifier().getName());
      }
    }
    if (discriminator == 0) {
      Out.$out(/*KEEP_STR*/"_block_invoke");
    } else {
      Out.$out(/*KEEP_STR*/"_block_invoke_").$out_uint(discriminator + 1);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleCtorBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 203,
   FQN="clang::MangleContext::mangleCtorBlock", NM="_ZN5clang13MangleContext15mangleCtorBlockEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEPKNS_9BlockDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext15mangleCtorBlockEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEPKNS_9BlockDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void mangleCtorBlock(/*const*/ CXXConstructorDecl /*P*/ CD, 
                 CXXCtorType CT, /*const*/ BlockDecl /*P*/ BD, 
                 final raw_ostream /*&*/ ResStream) {
    raw_svector_ostream Out = null;
    try {
      SmallString/*64*/ Buffer/*J*/= new SmallString/*64*/(64);
      Out/*J*/= new raw_svector_ostream(Buffer);
      mangleCXXCtor(CD, CT, Out);
      MangleStatics.mangleFunctionBlock(/*Deref*/this, Buffer.$StringRef(), BD, ResStream);
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleDtorBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 212,
   FQN="clang::MangleContext::mangleDtorBlock", NM="_ZN5clang13MangleContext15mangleDtorBlockEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEPKNS_9BlockDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext15mangleDtorBlockEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEPKNS_9BlockDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void mangleDtorBlock(/*const*/ CXXDestructorDecl /*P*/ DD, 
                 CXXDtorType DT, /*const*/ BlockDecl /*P*/ BD, 
                 final raw_ostream /*&*/ ResStream) {
    raw_svector_ostream Out = null;
    try {
      SmallString/*64*/ Buffer/*J*/= new SmallString/*64*/(64);
      Out/*J*/= new raw_svector_ostream(Buffer);
      mangleCXXDtor(DD, DT, Out);
      MangleStatics.mangleFunctionBlock(/*Deref*/this, Buffer.$StringRef(), BD, ResStream);
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 221,
   FQN="clang::MangleContext::mangleBlock", NM="_ZN5clang13MangleContext11mangleBlockEPKNS_11DeclContextEPKNS_9BlockDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext11mangleBlockEPKNS_11DeclContextEPKNS_9BlockDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void mangleBlock(/*const*/ DeclContext /*P*/ DC, /*const*/ BlockDecl /*P*/ BD, 
             final raw_ostream /*&*/ Out) {
    raw_svector_ostream Stream = null;
    try {
      assert (!isa_CXXConstructorDecl(DC) && !isa_CXXDestructorDecl(DC));
      
      SmallString/*64*/ Buffer/*J*/= new SmallString/*64*/(64);
      Stream/*J*/= new raw_svector_ostream(Buffer);
      {
        /*const*/ ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(DC);
        if ((Method != null)) {
          mangleObjCMethodName(Method, Stream);
        } else {
          assert ((isa_NamedDecl(DC) || isa_BlockDecl(DC))) : "expected a NamedDecl or BlockDecl";
          if (isa_BlockDecl(DC)) {
            for (; (DC != null) && isa_BlockDecl(DC); DC = DC.getParent$Const())  {
              /*J:(void)*/getBlockId(cast_BlockDecl(DC), true);
            }
          }
          assert ((isa_TranslationUnitDecl(DC) || isa_NamedDecl(DC))) : "expected a TranslationUnitDecl or a NamedDecl";
          {
            /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(DC);
            if ((CD != null)) {
              mangleCtorBlock(CD, /*CT*/ CXXCtorType.Ctor_Complete, BD, Out);
            } else {
              /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(DC);
              if ((DD != null)) {
                mangleDtorBlock(DD, /*DT*/ CXXDtorType.Dtor_Complete, BD, Out);
              } else {
                /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(DC);
                if ((ND != null)) {
                  if (!shouldMangleDeclName(ND) && (ND.getIdentifier() != null)) {
                    Stream.$out(ND.getIdentifier().getName());
                  } else {
                    // FIXME: We were doing a mangleUnqualifiedName() before, but that's
                    // a private member of a class that will soon itself be private to the
                    // Itanium C++ ABI object. What should we do now? Right now, I'm just
                    // calling the mangleName() method on the MangleContext; is there a
                    // better way?
                    mangleName(ND, Stream);
                  }
                }
              }
            }
          }
        }
      }
      MangleStatics.mangleFunctionBlock(/*Deref*/this, Buffer.$StringRef(), BD, Out);
    } finally {
      if (Stream != null) { Stream.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleObjCMethodNameWithoutSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 257,
   FQN="clang::MangleContext::mangleObjCMethodNameWithoutSize", NM="_ZN5clang13MangleContext31mangleObjCMethodNameWithoutSizeEPKNS_14ObjCMethodDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext31mangleObjCMethodNameWithoutSizeEPKNS_14ObjCMethodDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void mangleObjCMethodNameWithoutSize(/*const*/ ObjCMethodDecl /*P*/ MD, 
                                 final raw_ostream /*&*/ OS) {
    /*const*/ ObjCContainerDecl /*P*/ CD = dyn_cast_ObjCContainerDecl(MD.getDeclContext$Const());
    assert ((CD != null)) : "Missing container decl in GetNameForMethod";
    OS.$out_char((MD.isInstanceMethod() ? $$MINUS : $$PLUS)).$out_char($$LSQUARE).$out(CD.getName());
    {
      /*const*/ ObjCCategoryImplDecl /*P*/ CID = dyn_cast_ObjCCategoryImplDecl(CD);
      if ((CID != null)) {
        $out_raw_ostream_ObjCCategoryImplDecl$C(OS.$out_char($$LPAREN), $Deref(CID)).$out_char($$RPAREN);
      }
    }
    OS.$out_char($$SPACE);
    MD.getSelector().print(OS);
    OS.$out_char($$RSQUARE);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleObjCMethodName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 270,
   FQN="clang::MangleContext::mangleObjCMethodName", NM="_ZN5clang13MangleContext20mangleObjCMethodNameEPKNS_14ObjCMethodDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext20mangleObjCMethodNameEPKNS_14ObjCMethodDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void mangleObjCMethodName(/*const*/ ObjCMethodDecl /*P*/ MD, 
                      final raw_ostream /*&*/ Out) {
    raw_svector_ostream OS = null;
    try {
      SmallString/*64*/ Name/*J*/= new SmallString/*64*/(64);
      OS/*J*/= new raw_svector_ostream(Name);
      
      mangleObjCMethodNameWithoutSize(MD, OS);
      Out.$out_uint(OS.str().size()).$out(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleStaticGuardVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 130,
   FQN="clang::MangleContext::mangleStaticGuardVariable", NM="_ZN5clang13MangleContext25mangleStaticGuardVariableEPKNS_7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext25mangleStaticGuardVariableEPKNS_7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleStaticGuardVariable(/*const*/ VarDecl /*P*/ D, final raw_ostream /*&*/ $Prm1)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleDynamicInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 132,
   FQN="clang::MangleContext::mangleDynamicInitializer", NM="_ZN5clang13MangleContext24mangleDynamicInitializerEPKNS_7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext24mangleDynamicInitializerEPKNS_7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleDynamicInitializer(/*const*/ VarDecl /*P*/ D, final raw_ostream /*&*/ $Prm1)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleDynamicAtExitDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 134,
   FQN="clang::MangleContext::mangleDynamicAtExitDestructor", NM="_ZN5clang13MangleContext29mangleDynamicAtExitDestructorEPKNS_7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext29mangleDynamicAtExitDestructorEPKNS_7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleDynamicAtExitDestructor(/*const*/ VarDecl /*P*/ D, 
                               final raw_ostream /*&*/ $Prm1)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleSEHFilterExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 137,
   FQN="clang::MangleContext::mangleSEHFilterExpression", NM="_ZN5clang13MangleContext25mangleSEHFilterExpressionEPKNS_9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext25mangleSEHFilterExpressionEPKNS_9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleSEHFilterExpression(/*const*/ NamedDecl /*P*/ EnclosingDecl, 
                           final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleSEHFinallyBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 140,
   FQN="clang::MangleContext::mangleSEHFinallyBlock", NM="_ZN5clang13MangleContext21mangleSEHFinallyBlockEPKNS_9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext21mangleSEHFinallyBlockEPKNS_9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleSEHFinallyBlock(/*const*/ NamedDecl /*P*/ EnclosingDecl, 
                       final raw_ostream /*&*/ Out)/* = 0*/;

  
  /// Generates a unique string for an externally visible type for use with TBAA
  /// or type uniquing.
  /// TODO: Extend this to internal types by generating names that are unique
  /// across translation units so it can be used with LTO.
  //<editor-fold defaultstate="collapsed" desc="clang::MangleContext::mangleTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 147,
   FQN="clang::MangleContext::mangleTypeName", NM="_ZN5clang13MangleContext14mangleTypeNameENS_8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZN5clang13MangleContext14mangleTypeNameENS_8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleTypeName(QualType T, final raw_ostream /*&*/ $Prm1)/* = 0*/;

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", GlobalBlockIds=" + GlobalBlockIds // NOI18N
              + ", LocalBlockIds=" + LocalBlockIds // NOI18N
              + ", AnonStructIds=" + AnonStructIds; // NOI18N
  }
/// @}
}
