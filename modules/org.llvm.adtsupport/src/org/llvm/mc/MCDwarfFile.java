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

package org.llvm.mc;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


/// \brief Instances of this class represent the name of the dwarf
/// .file directive and its associated dwarf file number in the MC file,
/// and MCDwarfFile's are created and uniqued by the MCContext class where
/// the file number for each is its index into the vector of DwarfFiles (note
/// index 0 is not used and not a valid dwarf file number).
//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 43,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 45,
 FQN="llvm::MCDwarfFile", NM="_ZN4llvm11MCDwarfFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm11MCDwarfFileE")
//</editor-fold>
public class/*struct*/ MCDwarfFile implements Destructors.ClassWithDestructor {
  // \brief The base name of the file without its directory path.
  // The StringRef references memory allocated in the MCContext.
  public std.string Name;
  
  // \brief The index into the list of directory names for this file name.
  public /*uint*/int DirIndex;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFile::MCDwarfFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 45,
   FQN="llvm::MCDwarfFile::MCDwarfFile", NM="_ZN4llvm11MCDwarfFileC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm11MCDwarfFileC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfFile(JD$Move _dparam, final MCDwarfFile /*&&*/$Prm0) {
    // : Name(static_cast<MCDwarfFile &&>().Name), DirIndex(static_cast<MCDwarfFile &&>().DirIndex) 
    //START JInit
    this.Name = new std.string(JD$Move.INSTANCE, $Prm0.Name);
    this.DirIndex = $Prm0.DirIndex;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFile::~MCDwarfFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 45,
   FQN="llvm::MCDwarfFile::~MCDwarfFile", NM="_ZN4llvm11MCDwarfFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm11MCDwarfFileD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Name.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFile::MCDwarfFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 45,
   FQN="llvm::MCDwarfFile::MCDwarfFile", NM="_ZN4llvm11MCDwarfFileC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm11MCDwarfFileC1Ev")
  //</editor-fold>
  public /*inline*/ MCDwarfFile() {
    // : Name() 
    //START JInit
    this.Name = new std.string();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", DirIndex=" + DirIndex; // NOI18N
  }
}
