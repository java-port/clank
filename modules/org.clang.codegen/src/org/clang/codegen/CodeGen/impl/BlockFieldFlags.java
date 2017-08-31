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

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 113,
 FQN="clang::CodeGen::BlockFieldFlags", NM="_ZN5clang7CodeGen15BlockFieldFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15BlockFieldFlagsE")
//</editor-fold>
public class BlockFieldFlags {
  private /*uint32_t*/int flags;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags::BlockFieldFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 116,
   FQN="clang::CodeGen::BlockFieldFlags::BlockFieldFlags", NM="_ZN5clang7CodeGen15BlockFieldFlagsC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15BlockFieldFlagsC1Ej")
  //</editor-fold>
  /*friend*/public/*private*/ BlockFieldFlags(/*uint32_t*/int flags) {
    // : flags(flags) 
    //START JInit
    this.flags = flags;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags::BlockFieldFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 118,
   FQN="clang::CodeGen::BlockFieldFlags::BlockFieldFlags", NM="_ZN5clang7CodeGen15BlockFieldFlagsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15BlockFieldFlagsC1Ev")
  //</editor-fold>
  /*friend*/public/*public*/ BlockFieldFlags() {
    // : flags(0) 
    //START JInit
    this.flags = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags::BlockFieldFlags">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 119,
   FQN="clang::CodeGen::BlockFieldFlags::BlockFieldFlags", NM="_ZN5clang7CodeGen15BlockFieldFlagsC1ENS0_16BlockFieldFlag_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15BlockFieldFlagsC1ENS0_16BlockFieldFlag_tE")
  //</editor-fold>
  /*friend*/public/*public*/ BlockFieldFlags(JD$UInt diff, /*BlockFieldFlag_t*//*uint*/int flag) {
    // : flags(flag) 
    //START JInit
    this.flags = flag;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags::getBitMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 121,
   FQN="clang::CodeGen::BlockFieldFlags::getBitMask", NM="_ZNK5clang7CodeGen15BlockFieldFlags10getBitMaskEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen15BlockFieldFlags10getBitMaskEv")
  //</editor-fold>
  public /*uint32_t*/int getBitMask() /*const*/ {
    return flags;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 122,
   FQN="clang::CodeGen::BlockFieldFlags::empty", NM="_ZNK5clang7CodeGen15BlockFieldFlags5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen15BlockFieldFlags5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return flags == 0;
  }

  
  /// Answers whether the flags indicate that this field is an object
  /// or block pointer that requires _Block_object_assign/dispose.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags::isSpecialPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 126,
   FQN="clang::CodeGen::BlockFieldFlags::isSpecialPointer", NM="_ZNK5clang7CodeGen15BlockFieldFlags16isSpecialPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen15BlockFieldFlags16isSpecialPointerEv")
  //</editor-fold>
  public boolean isSpecialPointer() /*const*/ {
    return ((flags & BlockFieldFlag_t.BLOCK_FIELD_IS_OBJECT) != 0);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator|">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 128,
   FQN="clang::CodeGen::operator|", NM="_ZN5clang7CodeGenorENS0_15BlockFieldFlagsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGenorENS0_15BlockFieldFlagsES1_")
  //</editor-fold>
  public static BlockFieldFlags $bitor_BlockFieldFlags(BlockFieldFlags l, BlockFieldFlags r) {
    return new BlockFieldFlags(l.flags | r.flags);
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator|=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 131,
   FQN="clang::CodeGen::operator|=", NM="_ZN5clang7CodeGenoRERNS0_15BlockFieldFlagsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGenoRERNS0_15BlockFieldFlagsES1_")
  //</editor-fold>
  public static BlockFieldFlags /*&*/ $orassign_BlockFieldFlags(final BlockFieldFlags /*&*/ l, BlockFieldFlags r) {
    l.flags |= r.flags;
    return l;
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator&">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 135,
   FQN="clang::CodeGen::operator&", NM="_ZN5clang7CodeGenanENS0_15BlockFieldFlagsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGenanENS0_15BlockFieldFlagsES1_")
  //</editor-fold>
  public static boolean $bitand_BlockFieldFlags(BlockFieldFlags l, BlockFieldFlags r) {
    return ((l.flags & r.flags) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags::BlockFieldFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 113,
   FQN="clang::CodeGen::BlockFieldFlags::BlockFieldFlags", NM="_ZN5clang7CodeGen15BlockFieldFlagsC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15BlockFieldFlagsC1ERKS1_")
  //</editor-fold>
  /*friend*/public/*public*/ /*inline*/ BlockFieldFlags(final /*const*/ BlockFieldFlags /*&*/ $Prm0) {
    // : flags(.flags) 
    //START JInit
    this.flags = $Prm0.flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags::BlockFieldFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 113,
   FQN="clang::CodeGen::BlockFieldFlags::BlockFieldFlags", NM="_ZN5clang7CodeGen15BlockFieldFlagsC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15BlockFieldFlagsC1EOS1_")
  //</editor-fold>
  /*friend*/public/*public*/ /*inline*/ BlockFieldFlags(JD$Move _dparam, final BlockFieldFlags /*&&*/$Prm0) {
    // : flags(static_cast<BlockFieldFlags &&>().flags) 
    //START JInit
    this.flags = $Prm0.flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFieldFlags::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 113,
   FQN="clang::CodeGen::BlockFieldFlags::operator=", NM="_ZN5clang7CodeGen15BlockFieldFlagsaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15BlockFieldFlagsaSEOS1_")
  //</editor-fold>
  public /*inline*/ BlockFieldFlags /*&*/ $assignMove(final BlockFieldFlags /*&&*/$Prm0) {
    this.flags = $Prm0.flags;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "flags=" + flags; // NOI18N
  }
}
