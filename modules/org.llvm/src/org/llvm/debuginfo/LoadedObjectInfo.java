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

package org.llvm.debuginfo;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.object.*;


/// An inferface for inquiring the load address of a loaded object file
/// to be used by the DIContext implementations when applying relocations
/// on the fly.
//<editor-fold defaultstate="collapsed" desc="llvm::LoadedObjectInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 157,
 FQN="llvm::LoadedObjectInfo", NM="_ZN4llvm16LoadedObjectInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm16LoadedObjectInfoE")
//</editor-fold>
public abstract class LoadedObjectInfo implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadedObjectInfo::LoadedObjectInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 159,
   FQN="llvm::LoadedObjectInfo::LoadedObjectInfo", NM="_ZN4llvm16LoadedObjectInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm16LoadedObjectInfoC1ERKS0_")
  //</editor-fold>
  protected LoadedObjectInfo(final /*const*/ LoadedObjectInfo /*&*/ $Prm0)/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::LoadedObjectInfo::LoadedObjectInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 160,
   FQN="llvm::LoadedObjectInfo::LoadedObjectInfo", NM="_ZN4llvm16LoadedObjectInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm16LoadedObjectInfoC1Ev")
  //</editor-fold>
  protected LoadedObjectInfo()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadedObjectInfo::~LoadedObjectInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 163,
   FQN="llvm::LoadedObjectInfo::~LoadedObjectInfo", NM="_ZN4llvm16LoadedObjectInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm16LoadedObjectInfoD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Obtain the Load Address of a section by SectionRef.
  ///
  /// Calculate the address of the given section.
  /// The section need not be present in the local address space. The addresses
  /// need to be consistent with the addresses used to query the DIContext and
  /// the output of this function should be deterministic, i.e. repeated calls with
  /// the same Sec should give the same address.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadedObjectInfo::getSectionLoadAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 172,
   FQN="llvm::LoadedObjectInfo::getSectionLoadAddress", NM="_ZNK4llvm16LoadedObjectInfo21getSectionLoadAddressERKNS_6object10SectionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm16LoadedObjectInfo21getSectionLoadAddressERKNS_6object10SectionRefE")
  //</editor-fold>
  public abstract /*virtual*/ long/*uint64_t*/ getSectionLoadAddress(final /*const*/ SectionRef /*&*/ Sec) /*const*//* = 0*/;

  
  /// If conveniently available, return the content of the given Section.
  ///
  /// When the section is available in the local address space, in relocated (loaded)
  /// form, e.g. because it was relocated by a JIT for execution, this function
  /// should provide the contents of said section in `Data`. If the loaded section
  /// is not available, or the cost of retrieving it would be prohibitive, this
  /// function should return false. In that case, relocations will be read from the
  /// local (unrelocated) object file and applied on the fly. Note that this method
  /// is used purely for optimzation purposes in the common case of JITting in the
  /// local address space, so returning false should always be correct.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadedObjectInfo::getLoadedSectionContents">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 184,
   FQN="llvm::LoadedObjectInfo::getLoadedSectionContents", NM="_ZNK4llvm16LoadedObjectInfo24getLoadedSectionContentsERKNS_6object10SectionRefERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm16LoadedObjectInfo24getLoadedSectionContentsERKNS_6object10SectionRefERNS_9StringRefE")
  //</editor-fold>
  public /*virtual*/ boolean getLoadedSectionContents(final /*const*/ SectionRef /*&*/ Sec, 
                          final StringRef /*&*/ Data) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Obtain a copy of this LoadedObjectInfo.
  ///
  /// The caller is responsible for deallocation once the copy is no longer required.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadedObjectInfo::clone">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 192,
   FQN="llvm::LoadedObjectInfo::clone", NM="_ZNK4llvm16LoadedObjectInfo5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm16LoadedObjectInfo5cloneEv")
  //</editor-fold>
  public abstract /*virtual*/ std.unique_ptr<LoadedObjectInfo> clone() /*const*//* = 0*/;

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
