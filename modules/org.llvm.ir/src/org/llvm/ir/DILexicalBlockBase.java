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

package org.llvm.ir;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.dwarf.Tag;

//<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1472,
 FQN="llvm::DILexicalBlockBase", NM="_ZN4llvm18DILexicalBlockBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockBaseE")
//</editor-fold>
public class DILexicalBlockBase extends /*public*/ DILocalScope implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockBase::DILexicalBlockBase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1474,
   FQN="llvm::DILexicalBlockBase::DILexicalBlockBase", NM="_ZN4llvm18DILexicalBlockBaseC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockBaseC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EE")
  //</editor-fold>
  protected DILexicalBlockBase(final LLVMContext /*&*/ C, /*uint*/int ID, Metadata.StorageType Storage,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DILocalScope(C, ID, Storage, dwarf::DW_TAG_lexical_block, Ops)
    //START JInit
    super(C, ID, Storage, $ushort2uint(Tag.DW_TAG_lexical_block), new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockBase::~DILexicalBlockBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1477,
   FQN="llvm::DILexicalBlockBase::~DILexicalBlockBase", NM="_ZN4llvm18DILexicalBlockBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockBaseD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    super.$destroy();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockBase::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1480,
   FQN="llvm::DILexicalBlockBase::getScope", NM="_ZNK4llvm18DILexicalBlockBase8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm18DILexicalBlockBase8getScopeEv")
  //</editor-fold>
  public DILocalScope /*P*/ getScope() /*const*/ {
    return cast_DILocalScope(getRawScope());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockBase::getRawScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1482,
   FQN="llvm::DILexicalBlockBase::getRawScope", NM="_ZNK4llvm18DILexicalBlockBase11getRawScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm18DILexicalBlockBase11getRawScopeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawScope() /*const*/ {
    return getOperand(1).$Metadata$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockBase::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1484,
   FQN="llvm::DILexicalBlockBase::classof", NM="_ZN4llvm18DILexicalBlockBase7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockBase7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DILexicalBlockKind.getValue()
       || MD.getMetadataID() == MetadataKind.DILexicalBlockFileKind.getValue();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
