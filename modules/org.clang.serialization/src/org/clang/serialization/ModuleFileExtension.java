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

package org.clang.serialization;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.bitcode.*;
import org.llvm.adt.*;
import org.llvm.adt.HashingGlobals.hash_code;


/// An abstract superclass that describes a custom extension to the
/// module/precompiled header file format.
///
/// A module file extension can introduce additional information into
/// compiled module files (.pcm) and precompiled headers (.pch) via a
/// custom writer that can then be accessed via a custom reader when
/// the module file or precompiled header is loaded.
//<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtension">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleFileExtension.h", line = 63,
 FQN="clang::ModuleFileExtension", NM="_ZN5clang19ModuleFileExtensionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp -nm=_ZN5clang19ModuleFileExtensionE")
//</editor-fold>
public abstract class ModuleFileExtension extends /*public*/ RefCountedBase<ModuleFileExtension> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtension::~ModuleFileExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp", line = 14,
   FQN="clang::ModuleFileExtension::~ModuleFileExtension", NM="_ZN5clang19ModuleFileExtensionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp -nm=_ZN5clang19ModuleFileExtensionD0Ev")
  //</editor-fold>
  public void $destroy() {
    super.$destroy();
  }

  
  /// Retrieves the metadata for this module file extension.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtension::getExtensionMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleFileExtension.h", line = 68,
   FQN="clang::ModuleFileExtension::getExtensionMetadata", NM="_ZNK5clang19ModuleFileExtension20getExtensionMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp -nm=_ZNK5clang19ModuleFileExtension20getExtensionMetadataEv")
  //</editor-fold>
  public abstract /*virtual*/ ModuleFileExtensionMetadata getExtensionMetadata() /*const*//* = 0*/;

  
  /// Hash information about the presence of this extension into the
  /// module hash code.
  ///
  /// The module hash code is used to distinguish different variants
  /// of a module that are incompatible. If the presence, absence, or
  /// version of the module file extension should force the creation
  /// of a separate set of module files, override this method to
  /// combine that distinguishing information into the module hash
  /// code.
  ///
  /// The default implementation of this function simply returns the
  /// hash code as given, so the presence/absence of this extension
  /// does not distinguish module files.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtension::hashExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp", line = 16,
   FQN="clang::ModuleFileExtension::hashExtension", NM="_ZNK5clang19ModuleFileExtension13hashExtensionEN4llvm9hash_codeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp -nm=_ZNK5clang19ModuleFileExtension13hashExtensionEN4llvm9hash_codeE")
  //</editor-fold>
  public hash_code hashExtension(hash_code Code) /*const*/ {
    return new hash_code(JD$Move.INSTANCE, Code);
  }

  
  /// Create a new module file extension writer, which will be
  /// responsible for writing the extension contents into a particular
  /// module file.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtension::createExtensionWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleFileExtension.h", line = 88,
   FQN="clang::ModuleFileExtension::createExtensionWriter", NM="_ZN5clang19ModuleFileExtension21createExtensionWriterERNS_9ASTWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp -nm=_ZN5clang19ModuleFileExtension21createExtensionWriterERNS_9ASTWriterE")
  //</editor-fold>
  public abstract /*virtual*/ std.unique_ptr<ModuleFileExtensionWriter> createExtensionWriter(final ASTWriter /*&*/ Writer)/* = 0*/;

  
  /// Create a new module file extension reader, given the
  /// metadata read from the block and the cursor into the extension
  /// block.
  ///
  /// May return null to indicate that an extension block with the
  /// given metadata cannot be read.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtension::createExtensionReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleFileExtension.h", line = 97,
   FQN="clang::ModuleFileExtension::createExtensionReader", NM="_ZN5clang19ModuleFileExtension21createExtensionReaderERKNS_27ModuleFileExtensionMetadataERNS_9ASTReaderERNS_13serialization10ModuleFileERKN4llvm15BitstreamCursorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp -nm=_ZN5clang19ModuleFileExtension21createExtensionReaderERKNS_27ModuleFileExtensionMetadataERNS_9ASTReaderERNS_13serialization10ModuleFileERKN4llvm15BitstreamCursorE")
  //</editor-fold>
  public abstract /*virtual*/ std.unique_ptr<ModuleFileExtensionReader> createExtensionReader(final /*const*/ ModuleFileExtensionMetadata /*&*/ Metadata, 
                       final ASTReader /*&*/ Reader, final ModuleFile /*&*/ Mod, 
                       final /*const*/ BitstreamCursor /*&*/ Stream)/* = 0*/;


  //<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtension::ModuleFileExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleFileExtension.h", line = 63,
   FQN="clang::ModuleFileExtension::ModuleFileExtension", NM="_ZN5clang19ModuleFileExtensionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang19ModuleFileExtensionC1Ev")
  //</editor-fold>
  public /*inline*/ ModuleFileExtension() {
    // : RefCountedBase<ModuleFileExtension>() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
