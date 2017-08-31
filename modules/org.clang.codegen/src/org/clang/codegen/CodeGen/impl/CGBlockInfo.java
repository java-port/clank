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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;


/// CGBlockInfo - Information to generate a block literal.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 153,
 FQN="clang::CodeGen::CGBlockInfo", NM="_ZN5clang7CodeGen11CGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfoE")
//</editor-fold>
public class CGBlockInfo implements Destructors.ClassWithDestructor {
/*public:*/
  /// Name - The name of the block, kindof.
  public StringRef Name;
  
  /// The field index of 'this' within the block, if there is one.
  public /*uint*/int CXXThisIndex;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 161,
   FQN="clang::CodeGen::CGBlockInfo::Capture", NM="_ZN5clang7CodeGen11CGBlockInfo7CaptureE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfo7CaptureE")
  //</editor-fold>
  public static class Capture implements NativeCloneable<Capture> {
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
    private Value/*uintptr_t*/ Data;
    private EHScopeStack.stable_iterator Cleanup;
    private long/*int64_t*/ Offset;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::isIndex">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 167,
     FQN="clang::CodeGen::CGBlockInfo::Capture::isIndex", NM="_ZNK5clang7CodeGen11CGBlockInfo7Capture7isIndexEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen11CGBlockInfo7Capture7isIndexEv")
    //</editor-fold>
    public boolean isIndex() /*const*/ {
      return Data == null;//(Data & 1) != 0;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::isConstant">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 168,
     FQN="clang::CodeGen::CGBlockInfo::Capture::isConstant", NM="_ZNK5clang7CodeGen11CGBlockInfo7Capture10isConstantEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen11CGBlockInfo7Capture10isConstantEv")
    //</editor-fold>
    public boolean isConstant() /*const*/ {
      return !isIndex();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::getIndex">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 170,
     FQN="clang::CodeGen::CGBlockInfo::Capture::getIndex", NM="_ZNK5clang7CodeGen11CGBlockInfo7Capture8getIndexEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen11CGBlockInfo7Capture8getIndexEv")
    //</editor-fold>
    public /*uint*/int getIndex() /*const*/ {
      assert (isIndex());
      return Index;//Data >>> 1;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::getOffset">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 174,
     FQN="clang::CodeGen::CGBlockInfo::Capture::getOffset", NM="_ZNK5clang7CodeGen11CGBlockInfo7Capture9getOffsetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen11CGBlockInfo7Capture9getOffsetEv")
    //</editor-fold>
    public CharUnits getOffset() /*const*/ {
      assert (isIndex());
      return CharUnits.fromQuantity(Offset);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::getCleanup">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 178,
     FQN="clang::CodeGen::CGBlockInfo::Capture::getCleanup", NM="_ZNK5clang7CodeGen11CGBlockInfo7Capture10getCleanupEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen11CGBlockInfo7Capture10getCleanupEv")
    //</editor-fold>
    public EHScopeStack.stable_iterator getCleanup() /*const*/ {
      assert (isIndex());
      return new EHScopeStack.stable_iterator(Cleanup);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::setCleanup">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 182,
     FQN="clang::CodeGen::CGBlockInfo::Capture::setCleanup", NM="_ZN5clang7CodeGen11CGBlockInfo7Capture10setCleanupENS0_12EHScopeStack15stable_iteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfo7Capture10setCleanupENS0_12EHScopeStack15stable_iteratorE")
    //</editor-fold>
    public void setCleanup(EHScopeStack.stable_iterator cleanup) {
      assert (isIndex());
      Cleanup.$assign(cleanup);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::getConstant">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 187,
     FQN="clang::CodeGen::CGBlockInfo::Capture::getConstant", NM="_ZNK5clang7CodeGen11CGBlockInfo7Capture11getConstantEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen11CGBlockInfo7Capture11getConstantEv")
    //</editor-fold>
    public Value /*P*/ getConstant() /*const*/ {
      assert (isConstant());
      return Data;//reinterpret_cast(Value /*P*/ .class, Data);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::makeIndex">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 192,
     FQN="clang::CodeGen::CGBlockInfo::Capture::makeIndex", NM="_ZN5clang7CodeGen11CGBlockInfo7Capture9makeIndexEjNS_9CharUnitsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfo7Capture9makeIndexEjNS_9CharUnitsE")
    //</editor-fold>
    public static Capture makeIndex(/*uint*/int index, CharUnits offset) {
      Capture v/*J*/= new Capture();
      v.Index = index;//(index << 1) | 1;
      v.Offset = offset.getQuantity();
      return v;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::makeConstant">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 199,
     FQN="clang::CodeGen::CGBlockInfo::Capture::makeConstant", NM="_ZN5clang7CodeGen11CGBlockInfo7Capture12makeConstantEPN4llvm5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfo7Capture12makeConstantEPN4llvm5ValueE")
    //</editor-fold>
    public static Capture makeConstant(Value /*P*/ value) {
      Capture v/*J*/= new Capture();
      v.Data = value;//reinterpret_cast_Object/*uintptr_t*/(value);
      return v;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::Capture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 161,
     FQN="clang::CodeGen::CGBlockInfo::Capture::Capture", NM="_ZN5clang7CodeGen11CGBlockInfo7CaptureC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfo7CaptureC1Ev")
    //</editor-fold>
    public /*inline*/ Capture() {
      // : Cleanup() 
      //START JInit
      this.Cleanup = new EHScopeStack.stable_iterator();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::Capture">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 161,
     FQN="clang::CodeGen::CGBlockInfo::Capture::Capture", NM="_ZN5clang7CodeGen11CGBlockInfo7CaptureC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfo7CaptureC1ERKS2_")
    //</editor-fold>
    public /*inline*/ Capture(final /*const*/ Capture /*&*/ $Prm0) {
      // : Data(.Data), Cleanup(.Cleanup), Offset(.Offset) 
      //START JInit
      this.Data = $Prm0.Data;
      this.Index = $Prm0.Index;
      this.Cleanup = new EHScopeStack.stable_iterator($Prm0.Cleanup);
      this.Offset = $Prm0.Offset;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::Capture">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 161,
     FQN="clang::CodeGen::CGBlockInfo::Capture::Capture", NM="_ZN5clang7CodeGen11CGBlockInfo7CaptureC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfo7CaptureC1EOS2_")
    //</editor-fold>
    public /*inline*/ Capture(JD$Move _dparam, final Capture /*&&*/$Prm0) {
      // : Data(static_cast<Capture &&>().Data), Cleanup(static_cast<Capture &&>().Cleanup), Offset(static_cast<Capture &&>().Offset) 
      //START JInit
      this.Data = $Prm0.Data;
      this.Index = $Prm0.Index;
      this.Cleanup = new EHScopeStack.stable_iterator(JD$Move.INSTANCE, $Prm0.Cleanup);
      this.Offset = $Prm0.Offset;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::Capture::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 161,
     FQN="clang::CodeGen::CGBlockInfo::Capture::operator=", NM="_ZN5clang7CodeGen11CGBlockInfo7CaptureaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfo7CaptureaSEOS2_")
    //</editor-fold>
    public /*inline*/ Capture /*&*/ $assignMove(final Capture /*&&*/$Prm0) {
      this.Data = $Prm0.Data;
      this.Index = $Prm0.Index;
      this.Cleanup.$assignMove($Prm0.Cleanup);
      this.Offset = $Prm0.Offset;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private int Index;

    @Override public Capture clone() {
      return new Capture(this);
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Data=" + Data // NOI18N
                + ", Cleanup=" + Cleanup // NOI18N
                + ", Offset=" + Offset; // NOI18N
    }
  };
  
  /// CanBeGlobal - True if the block can be global, i.e. it has
  /// no non-constant captures.
  public /*JBIT bool*/ boolean CanBeGlobal /*: 1*/;
  
  /// True if the block needs a custom copy or dispose function.
  public /*JBIT bool*/ boolean NeedsCopyDispose /*: 1*/;
  
  /// HasCXXObject - True if the block's custom copy/dispose functions
  /// need to be run even in GC mode.
  public /*JBIT bool*/ boolean HasCXXObject /*: 1*/;
  
  /// UsesStret : True if the block uses an stret return.  Mutable
  /// because it gets set later in the block-creation process.
  public /*mutable *//*JBIT bool*/ boolean UsesStret /*: 1*/;
  
  /// HasCapturedVariableLayout : True if block has captured variables
  /// and their layout meta-data has been generated.
  public /*JBIT bool*/ boolean HasCapturedVariableLayout /*: 1*/;
  
  /// The mapping of allocated indexes within the block.
  public DenseMap</*const*/ VarDecl /*P*/ , Capture> Captures;
  
  public Address LocalAddress;
  public StructType /*P*/ StructureType;
  public /*const*/ BlockDecl /*P*/ Block;
  public /*const*/ BlockExpr /*P*/ BlockExpression;
  public CharUnits BlockSize;
  public CharUnits BlockAlign;
  public CharUnits CXXThisOffset;
  
  // Offset of the gap caused by block header having a smaller
  // alignment than the alignment of the block descriptor. This
  // is the gap offset before the first capturued field.
  public CharUnits BlockHeaderForcedGapOffset;
  // Gap size caused by aligning first field after block header.
  // This could be zero if no forced alignment is required.
  public CharUnits BlockHeaderForcedGapSize;
  
  /// An instruction which dominates the full-expression that the
  /// block is inside.
  public Instruction /*P*/ DominatingIP;
  
  /// The next block in the block-info chain.  Invalid if this block
  /// info is not part of the CGF's block-info chain, which is true
  /// if it corresponds to a global block or a block whose expression
  /// has been encountered.
  public CGBlockInfo /*P*/ NextBlockInfo;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::getCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 254,
   FQN="clang::CodeGen::CGBlockInfo::getCapture", NM="_ZNK5clang7CodeGen11CGBlockInfo10getCaptureEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen11CGBlockInfo10getCaptureEPKNS_7VarDeclE")
  //</editor-fold>
  public /*const*/ Capture /*&*/ getCapture$Const(/*const*/ VarDecl /*P*/ var) /*const*/ {
    return ((/*const_cast*/CGBlockInfo /*P*/ )(this)).getCapture(var);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::getCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 257,
   FQN="clang::CodeGen::CGBlockInfo::getCapture", NM="_ZN5clang7CodeGen11CGBlockInfo10getCaptureEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfo10getCaptureEPKNS_7VarDeclE")
  //</editor-fold>
  public Capture /*&*/ getCapture(/*const*/ VarDecl /*P*/ var) {
    DenseMapIterator</*const*/ VarDecl /*P*/ , Capture> it = Captures.find(var);
    assert (it.$noteq(/*NO_ITER_COPY*/Captures.end())) : "no entry for variable!";
    return it.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::getBlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 264,
   FQN="clang::CodeGen::CGBlockInfo::getBlockDecl", NM="_ZNK5clang7CodeGen11CGBlockInfo12getBlockDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen11CGBlockInfo12getBlockDeclEv")
  //</editor-fold>
  public /*const*/ BlockDecl /*P*/ getBlockDecl() /*const*/ {
    return Block;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::getBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 265,
   FQN="clang::CodeGen::CGBlockInfo::getBlockExpr", NM="_ZNK5clang7CodeGen11CGBlockInfo12getBlockExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen11CGBlockInfo12getBlockExprEv")
  //</editor-fold>
  public /*const*/ BlockExpr /*P*/ getBlockExpr() /*const*/ {
    assert Native.$bool(BlockExpression);
    assert (BlockExpression.getBlockDecl$Const() == Block);
    return BlockExpression;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::CGBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 30,
   FQN="clang::CodeGen::CGBlockInfo::CGBlockInfo", NM="_ZN5clang7CodeGen11CGBlockInfoC1EPKNS_9BlockDeclEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfoC1EPKNS_9BlockDeclEN4llvm9StringRefE")
  //</editor-fold>
  public CGBlockInfo(/*const*/ BlockDecl /*P*/ block, StringRef name) {
    // : Name(name), CXXThisIndex(0), CanBeGlobal(false), NeedsCopyDispose(false), HasCXXObject(false), UsesStret(false), HasCapturedVariableLayout(false), Captures(), LocalAddress(Address::invalid()), StructureType(null), Block(block), BlockSize(), BlockAlign(), CXXThisOffset(), BlockHeaderForcedGapOffset(), BlockHeaderForcedGapSize(), DominatingIP(null) 
    //START JInit
    this.Name = new StringRef(name);
    this.CXXThisIndex = 0;
    this.CanBeGlobal = false;
    this.NeedsCopyDispose = false;
    this.HasCXXObject = false;
    this.UsesStret = false;
    this.HasCapturedVariableLayout = false;
    this.Captures = new DenseMap</*const*/ VarDecl /*P*/ , Capture>(DenseMapInfo$LikePtr.$Info(), new Capture());
    this.LocalAddress = Address.invalid();
    this.StructureType = null;
    this.Block = block;
    this.BlockSize = new CharUnits();
    this.BlockAlign = new CharUnits();
    this.CXXThisOffset = new CharUnits();
    this.BlockHeaderForcedGapOffset = new CharUnits();
    this.BlockHeaderForcedGapSize = new CharUnits();
    this.DominatingIP = null;
    //END JInit
    
    // Skip asm prefix, if any.  'name' is usually taken directly from
    // the mangled name of the enclosing function.
    if (!name.empty() && name.$at(0) == $$SOH) {
      name.$assignMove(name.substr(1));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBlockInfo::~CGBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 153,
   FQN="clang::CodeGen::CGBlockInfo::~CGBlockInfo", NM="_ZN5clang7CodeGen11CGBlockInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen11CGBlockInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Captures.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", CXXThisIndex=" + CXXThisIndex // NOI18N
              + ", CanBeGlobal=" + CanBeGlobal // NOI18N
              + ", NeedsCopyDispose=" + NeedsCopyDispose // NOI18N
              + ", HasCXXObject=" + HasCXXObject // NOI18N
              + ", UsesStret=" + UsesStret // NOI18N
              + ", HasCapturedVariableLayout=" + HasCapturedVariableLayout // NOI18N
              + ", Captures=" + Captures // NOI18N
              + ", LocalAddress=" + LocalAddress // NOI18N
              + ", StructureType=" + StructureType // NOI18N
              + ", Block=" + "[BlockDecl]" // NOI18N
              + ", BlockExpression=" + "[BlockExpr]" // NOI18N
              + ", BlockSize=" + BlockSize // NOI18N
              + ", BlockAlign=" + BlockAlign // NOI18N
              + ", CXXThisOffset=" + CXXThisOffset // NOI18N
              + ", BlockHeaderForcedGapOffset=" + BlockHeaderForcedGapOffset // NOI18N
              + ", BlockHeaderForcedGapSize=" + BlockHeaderForcedGapSize // NOI18N
              + ", DominatingIP=" + DominatingIP // NOI18N
              + ", NextBlockInfo=" + NextBlockInfo; // NOI18N
  }
}
