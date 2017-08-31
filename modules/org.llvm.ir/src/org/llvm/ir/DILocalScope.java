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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief A scope for locals.
///
/// A legal scope for lexical blocks, local variables, and debug info
/// locations.  Subclasses are \a DISubprogram, \a DILexicalBlock, and \a
/// DILexicalBlockFile.
//<editor-fold defaultstate="collapsed" desc="llvm::DILocalScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1142,
 FQN="llvm::DILocalScope", NM="_ZN4llvm12DILocalScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DILocalScopeE")
//</editor-fold>
public class DILocalScope extends /*public*/ DIScope implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalScope::DILocalScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1144,
   FQN="llvm::DILocalScope::DILocalScope", NM="_ZN4llvm12DILocalScopeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DILocalScopeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  protected DILocalScope(final LLVMContext /*&*/ C, /*uint*/int ID, Metadata.StorageType Storage, /*uint*/int Tag,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DIScope(C, ID, Storage, Tag, Ops)
    //START JInit
    super(C, ID, Storage, Tag, new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalScope::~DILocalScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1147,
   FQN="llvm::DILocalScope::~DILocalScope", NM="_ZN4llvm12DILocalScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DILocalScopeD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    super.$destroy();
  }

/*public:*/
  /// \brief Get the subprogram for this scope.
  ///
  /// Return this if it's an \a DISubprogram; otherwise, look up the scope
  /// chain.
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalScope::getSubprogram">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 398,
   FQN="llvm::DILocalScope::getSubprogram", NM="_ZNK4llvm12DILocalScope13getSubprogramEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DILocalScope13getSubprogramEv")
  //</editor-fold>
  public DISubprogram /*P*/ getSubprogram() /*const*/ {
    {
      /*const*/ DILexicalBlockBase /*P*/ Block = dyn_cast_DILexicalBlockBase(this);
      if ((Block != null)) {
        return Block.getScope().getSubprogram();
      }
    }
    return ((/*const_cast*/DISubprogram /*P*/ )(cast_DISubprogram(this)));
  }


  /// Get the first non DILexicalBlockFile scope of this scope.
  ///
  /// Return this if it's not a \a DILexicalBlockFIle; otherwise, look up the
  /// scope chain.
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalScope::getNonLexicalBlockFileScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 404,
   FQN="llvm::DILocalScope::getNonLexicalBlockFileScope", NM="_ZNK4llvm12DILocalScope27getNonLexicalBlockFileScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DILocalScope27getNonLexicalBlockFileScopeEv")
  //</editor-fold>
  public DILocalScope /*P*/ getNonLexicalBlockFileScope() /*const*/ {
    {
      /*const*/ DILexicalBlockFile /*P*/ File = dyn_cast_DILexicalBlockFile(this);
      if ((File != null)) {
        return File.getScope().getNonLexicalBlockFileScope();
      }
    }
    return ((/*const_cast*/DILocalScope /*P*/ )(this));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalScope::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1162,
   FQN="llvm::DILocalScope::classof", NM="_ZN4llvm12DILocalScope7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DILocalScope7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DISubprogramKind.getValue()
       || MD.getMetadataID() == MetadataKind.DILexicalBlockKind.getValue()
       || MD.getMetadataID() == MetadataKind.DILexicalBlockFileKind.getValue();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
