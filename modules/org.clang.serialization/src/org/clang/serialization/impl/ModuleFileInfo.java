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

package org.clang.serialization.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.aliases.*;

/// \brief Provides information about a specific module file.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleFileInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 376,
 FQN="(anonymous namespace)::ModuleFileInfo", NM="_ZN12_GLOBAL__N_114ModuleFileInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_114ModuleFileInfoE")
//</editor-fold>
public class/*struct*/ ModuleFileInfo implements Destructors.ClassWithDestructor, NativeCloneable<ModuleFileInfo>, NativeMoveable<ModuleFileInfo> {
  /// \brief The numberic ID for this module file.
  public /*uint*/int ID;
  
  /// \brief The set of modules on which this module depends. Each entry is
  /// a module ID.
  public SmallVectorUInt Dependencies;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleFileInfo::ModuleFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 376,
   FQN="(anonymous namespace)::ModuleFileInfo::ModuleFileInfo", NM="_ZN12_GLOBAL__N_114ModuleFileInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_114ModuleFileInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ ModuleFileInfo(JD$Move _dparam, final ModuleFileInfo /*&&*/$Prm0) {
    // : ID(static_cast<ModuleFileInfo &&>().ID), Dependencies(static_cast<ModuleFileInfo &&>().Dependencies) 
    //START JInit
    this.ID = $Prm0.ID;
    this.Dependencies = new SmallVectorUInt(JD$Move.INSTANCE, $Prm0.Dependencies);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleFileInfo::ModuleFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 376,
   FQN="(anonymous namespace)::ModuleFileInfo::ModuleFileInfo", NM="_ZN12_GLOBAL__N_114ModuleFileInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_114ModuleFileInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ModuleFileInfo(final /*const*/ ModuleFileInfo /*&*/ $Prm0) {
    // : ID(.ID), Dependencies(.Dependencies) 
    //START JInit
    this.ID = $Prm0.ID;
    this.Dependencies = new SmallVectorUInt($Prm0.Dependencies);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleFileInfo::~ModuleFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 376,
   FQN="(anonymous namespace)::ModuleFileInfo::~ModuleFileInfo", NM="_ZN12_GLOBAL__N_114ModuleFileInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_114ModuleFileInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Dependencies.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleFileInfo::ModuleFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 376,
   FQN="(anonymous namespace)::ModuleFileInfo::ModuleFileInfo", NM="_ZN12_GLOBAL__N_114ModuleFileInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_114ModuleFileInfoC1Ev")
  //</editor-fold>
  public /*inline*/ ModuleFileInfo() {
    // : Dependencies() 
    //START JInit
    this.Dependencies = new SmallVectorUInt(4, 0);
    //END JInit
  }

  @Override
  public ModuleFileInfo clone() {
    assert this.getClass() == ModuleFileInfo.class : "Must be overridden in " + this.getClass();
    return new ModuleFileInfo(this);
  }

  @Override
  public ModuleFileInfo move() {
    assert this.getClass() == ModuleFileInfo.class : "Must be overridden in " + this.getClass();
    return new ModuleFileInfo(JD$Move.INSTANCE, this);
  }
  
  @Override public String toString() {
    return "" + "ID=" + ID // NOI18N
              + ", Dependencies=" + Dependencies; // NOI18N
  }
}
