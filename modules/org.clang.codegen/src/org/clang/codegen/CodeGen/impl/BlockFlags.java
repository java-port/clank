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
import org.clang.codegen.java.ClangCodeGenJavaDifferentiators.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 68,
 FQN="clang::CodeGen::BlockFlags", NM="_ZN5clang7CodeGen10BlockFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen10BlockFlagsE")
//</editor-fold>
public class BlockFlags implements Native.NativeComparable<BlockFlags> {
  private /*uint32_t*/int flags;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags::BlockFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 72,
   FQN="clang::CodeGen::BlockFlags::BlockFlags", NM="_ZN5clang7CodeGen10BlockFlagsC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen10BlockFlagsC1Ej")
  //</editor-fold>
  public BlockFlags(/*uint32_t*/int flags) {
    // : flags(flags) 
    //START JInit
    this.flags = flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags::BlockFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 73,
   FQN="clang::CodeGen::BlockFlags::BlockFlags", NM="_ZN5clang7CodeGen10BlockFlagsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen10BlockFlagsC1Ev")
  //</editor-fold>
  public BlockFlags() {
    // : flags(0) 
    //START JInit
    this.flags = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags::BlockFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 74,
   FQN="clang::CodeGen::BlockFlags::BlockFlags", NM="_ZN5clang7CodeGen10BlockFlagsC1ENS0_17BlockLiteralFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen10BlockFlagsC1ENS0_17BlockLiteralFlagsE")
  //</editor-fold>
  public BlockFlags(JD$BlockLiteralFlags _dparam, /*BlockLiteralFlags*/int flag) {
    // : flags(flag) 
    //START JInit
    this.flags = flag;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags::BlockFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 75,
   FQN="clang::CodeGen::BlockFlags::BlockFlags", NM="_ZN5clang7CodeGen10BlockFlagsC1ENS0_15BlockByrefFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen10BlockFlagsC1ENS0_15BlockByrefFlagsE")
  //</editor-fold>
  public BlockFlags(JD$BlockByrefFlags _dparam, /*BlockByrefFlags*/int flag) {
    // : flags(flag) 
    //START JInit
    this.flags = flag;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags::getBitMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 77,
   FQN="clang::CodeGen::BlockFlags::getBitMask", NM="_ZNK5clang7CodeGen10BlockFlags10getBitMaskEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen10BlockFlags10getBitMaskEv")
  //</editor-fold>
  public /*uint32_t*/int getBitMask() /*const*/ {
    return flags;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 78,
   FQN="clang::CodeGen::BlockFlags::empty", NM="_ZNK5clang7CodeGen10BlockFlags5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen10BlockFlags5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return flags == 0;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator|">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 80,
   FQN="clang::CodeGen::operator|", NM="_ZN5clang7CodeGenorENS0_10BlockFlagsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGenorENS0_10BlockFlagsES1_")
  //</editor-fold>
  public static BlockFlags $bitor_BlockFlags(BlockFlags l, BlockFlags r) {
    return new BlockFlags(l.flags | r.flags);
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator|=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 83,
   FQN="clang::CodeGen::operator|=", NM="_ZN5clang7CodeGenoRERNS0_10BlockFlagsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGenoRERNS0_10BlockFlagsES1_")
  //</editor-fold>
  public static BlockFlags /*&*/ $orassign_BlockFlags(final BlockFlags /*&*/ l, BlockFlags r) {
    l.flags |= r.flags;
    return l;
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator&">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 87,
   FQN="clang::CodeGen::operator&", NM="_ZN5clang7CodeGenanENS0_10BlockFlagsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGenanENS0_10BlockFlagsES1_")
  //</editor-fold>
  public static boolean $bitand_BlockFlags(BlockFlags l, BlockFlags r) {
    return ((l.flags & r.flags) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 90,
   FQN="clang::CodeGen::BlockFlags::operator==", NM="_ZN5clang7CodeGen10BlockFlagseqES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen10BlockFlagseqES1_")
  //</editor-fold>
  public boolean $eq(BlockFlags r) {
    return (flags == r.flags);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags::BlockFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 68,
   FQN="clang::CodeGen::BlockFlags::BlockFlags", NM="_ZN5clang7CodeGen10BlockFlagsC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen10BlockFlagsC1ERKS1_")
  //</editor-fold>
  public /*inline*/ BlockFlags(final /*const*/ BlockFlags /*&*/ $Prm0) {
    // : flags(.flags) 
    //START JInit
    this.flags = $Prm0.flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockFlags::BlockFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 68,
   FQN="clang::CodeGen::BlockFlags::BlockFlags", NM="_ZN5clang7CodeGen10BlockFlagsC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen10BlockFlagsC1EOS1_")
  //</editor-fold>
  public /*inline*/ BlockFlags(JD$Move _dparam, final BlockFlags /*&&*/$Prm0) {
    // : flags(static_cast<BlockFlags &&>().flags) 
    //START JInit
    this.flags = $Prm0.flags;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "flags=" + flags; // NOI18N
  }
}
