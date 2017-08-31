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

// end namespace serialization

/// Metadata for a module file extension.
//<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtensionMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleFileExtension.h", line = 35,
 FQN="clang::ModuleFileExtensionMetadata", NM="_ZN5clang27ModuleFileExtensionMetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang27ModuleFileExtensionMetadataE")
//</editor-fold>
public class/*struct*/ ModuleFileExtensionMetadata implements Destructors.ClassWithDestructor {
  /// The name used to identify this particular extension block within
  /// the resulting module file. It should be unique to the particular
  /// extension, because this name will be used to match the name of
  /// an extension block to the appropriate reader.
  public std.string BlockName;
  
  /// The major version of the extension data.
  public /*uint*/int MajorVersion;
  
  /// The minor version of the extension data.
  public /*uint*/int MinorVersion;
  
  /// A string containing additional user information that will be
  /// stored with the metadata.
  public std.string UserInfo;
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtensionMetadata::~ModuleFileExtensionMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleFileExtension.h", line = 35,
   FQN="clang::ModuleFileExtensionMetadata::~ModuleFileExtensionMetadata", NM="_ZN5clang27ModuleFileExtensionMetadataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang27ModuleFileExtensionMetadataD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    UserInfo.$destroy();
    BlockName.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtensionMetadata::ModuleFileExtensionMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleFileExtension.h", line = 35,
   FQN="clang::ModuleFileExtensionMetadata::ModuleFileExtensionMetadata", NM="_ZN5clang27ModuleFileExtensionMetadataC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang27ModuleFileExtensionMetadataC1Ev")
  //</editor-fold>
  public /*inline*/ ModuleFileExtensionMetadata() {
    // : BlockName(), UserInfo() 
    //START JInit
    this.BlockName = new std.string();
    this.UserInfo = new std.string();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ModuleFileExtensionMetadata::ModuleFileExtensionMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleFileExtension.h", line = 35,
   FQN="clang::ModuleFileExtensionMetadata::ModuleFileExtensionMetadata", NM="_ZN5clang27ModuleFileExtensionMetadataC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang27ModuleFileExtensionMetadataC1EOS0_")
  //</editor-fold>
  public /*inline*/ ModuleFileExtensionMetadata(JD$Move _dparam, final ModuleFileExtensionMetadata /*&&*/$Prm0) {
    // : BlockName(static_cast<ModuleFileExtensionMetadata &&>().BlockName), MajorVersion(static_cast<ModuleFileExtensionMetadata &&>().MajorVersion), MinorVersion(static_cast<ModuleFileExtensionMetadata &&>().MinorVersion), UserInfo(static_cast<ModuleFileExtensionMetadata &&>().UserInfo) 
    //START JInit
    this.BlockName = new std.string(JD$Move.INSTANCE, $Prm0.BlockName);
    this.MajorVersion = $Prm0.MajorVersion;
    this.MinorVersion = $Prm0.MinorVersion;
    this.UserInfo = new std.string(JD$Move.INSTANCE, $Prm0.UserInfo);
    //END JInit
  }

  public ModuleFileExtensionMetadata(std.string BlockName, int MajorVersion, int MinorVersion, std.string UserInfo) {
    this.BlockName = BlockName;
    this.MajorVersion = MajorVersion;
    this.MinorVersion = MinorVersion;
    this.UserInfo = UserInfo;
  }
  
  @Override public String toString() {
    return "" + "BlockName=" + BlockName // NOI18N
              + ", MajorVersion=" + MajorVersion // NOI18N
              + ", MinorVersion=" + MinorVersion // NOI18N
              + ", UserInfo=" + UserInfo; // NOI18N
  }
}
