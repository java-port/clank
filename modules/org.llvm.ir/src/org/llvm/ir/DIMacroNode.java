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
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;


/// \brief Macro Info DWARF-like metadata node.
///
/// A metadata node with a DWARF macro info (i.e., a constant named
/// \c DW_MACINFO_*, defined in llvm/Support/Dwarf.h).  Called \a DIMacroNode
/// because it's potentially used for non-DWARF output.
//<editor-fold defaultstate="collapsed" desc="llvm::DIMacroNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2303,
 FQN="llvm::DIMacroNode", NM="_ZN4llvm11DIMacroNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroNodeE")
//</editor-fold>
public class DIMacroNode extends /*public*/ MDNode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroNode::DIMacroNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2308,
   FQN="llvm::DIMacroNode::DIMacroNode", NM="_ZN4llvm11DIMacroNodeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroNodeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EES7_")
  //</editor-fold>
  protected DIMacroNode(final LLVMContext /*&*/ C, /*uint*/int ID, Metadata.StorageType Storage, /*uint*/int MIType,
      ArrayRef<Metadata /*P*/ > Ops1) {
    this(C, ID, Storage, MIType,
      Ops1, new ArrayRef<Metadata /*P*/ >(None, true));
  }
  protected DIMacroNode(final LLVMContext /*&*/ C, /*uint*/int ID, Metadata.StorageType Storage, /*uint*/int MIType,
      ArrayRef<Metadata /*P*/ > Ops1, ArrayRef<Metadata /*P*/ > Ops2/*= None*/) {
    // : MDNode(C, ID, Storage, Ops1, Ops2)
    //START JInit
    super(C, ID, Storage, new ArrayRef<Metadata /*P*/ >(Ops1), new ArrayRef<Metadata /*P*/ >(Ops2));
    //END JInit
    assert ($less_uint(MIType, 1/*U*/ << 16));
    SubclassData16 = $uint2ushort(MIType);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroNode::~DIMacroNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2314,
   FQN="llvm::DIMacroNode::~DIMacroNode", NM="_ZN4llvm11DIMacroNodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroNodeD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    super.$destroy();
  }


  /*template <class Ty> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroNode::getOperandAs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2316,
   FQN="llvm::DIMacroNode::getOperandAs", NM="Tpl__ZNK4llvm11DIMacroNode12getOperandAsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=Tpl__ZNK4llvm11DIMacroNode12getOperandAsEj")
  //</editor-fold>
  protected </*class*/ Ty> Ty /*P*/ getOperandAs(Class<Ty> clazz,/*uint*/int I) /*const*/ {
    return cast_or_null(clazz, getOperand(I));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroNode::getStringOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2320,
   FQN="llvm::DIMacroNode::getStringOperand", NM="_ZNK4llvm11DIMacroNode16getStringOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIMacroNode16getStringOperandEj")
  //</editor-fold>
  protected StringRef getStringOperand(/*uint*/int I) /*const*/ {
    {
      MDString /*P*/ S = this.<MDString>getOperandAs(MDString.class, I);
      if ((S != null)) {
        return S.getString();
      }
    }
    return new StringRef();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroNode::getCanonicalMDString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2326,
   FQN="llvm::DIMacroNode::getCanonicalMDString", NM="_ZN4llvm11DIMacroNode20getCanonicalMDStringERNS_11LLVMContextENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroNode20getCanonicalMDStringERNS_11LLVMContextENS_9StringRefE")
  //</editor-fold>
  protected static MDString /*P*/ getCanonicalMDString(final LLVMContext /*&*/ Context, StringRef S) {
    if (S.empty()) {
      return null;
    }
    return MDString.get(Context, new StringRef(S));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroNode::getMacinfoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2333,
   FQN="llvm::DIMacroNode::getMacinfoType", NM="_ZNK4llvm11DIMacroNode14getMacinfoTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIMacroNode14getMacinfoTypeEv")
  //</editor-fold>
  public /*uint*/int getMacinfoType() /*const*/ {
    return $ushort2uint(SubclassData16);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroNode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2335,
   FQN="llvm::DIMacroNode::classof", NM="_ZN4llvm11DIMacroNode7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroNode7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    switch (Metadata.MetadataKind.valueOf(MD.getMetadataID())) {
     default:
      return false;
     case DIMacroKind:
     case DIMacroFileKind:
      return true;
    }
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
