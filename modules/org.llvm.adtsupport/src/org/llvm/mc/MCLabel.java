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

import org.clank.support.*;
import org.llvm.support.*;


/// MCLabel - Instances of this class represent a label name in the MC file,
/// and MCLabel are created and unique'd by the MCContext class.  MCLabel
/// should only be constructed for valid instances in the object file.
//<editor-fold defaultstate="collapsed" desc="llvm::MCLabel">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", line = 26,
 FQN = "llvm::MCLabel", NM = "_ZN4llvm7MCLabelE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZN4llvm7MCLabelE")
//</editor-fold>
public class MCLabel {
  // Instance - the instance number of this Directional Local Label
  private /*uint*/int Instance;
/*private:*/
  // MCContext creates and uniques these.
  /*friend  class MCContext*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLabel::MCLabel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", line = 32,
   FQN = "llvm::MCLabel::MCLabel", NM = "_ZN4llvm7MCLabelC1Ej",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZN4llvm7MCLabelC1Ej")
  //</editor-fold>
  public/*private*/ MCLabel(/*uint*/int instance) {
    /* : Instance(instance)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLabel::MCLabel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", line = 34,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", old_line = 35,
   FQN = "llvm::MCLabel::MCLabel", NM = "_ZN4llvm7MCLabelC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZN4llvm7MCLabelC1ERKS0_")
  //</editor-fold>
  private MCLabel(/*const*/MCLabel /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCLabel::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", old_line = 36,
   FQN = "llvm::MCLabel::operator=", NM = "_ZN4llvm7MCLabelaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZN4llvm7MCLabelaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/MCLabel /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  /// getInstance - Get the current instance of this Directional Local Label.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLabel::getInstance">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", line = 39,
   FQN = "llvm::MCLabel::getInstance", NM = "_ZNK4llvm7MCLabel11getInstanceEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZNK4llvm7MCLabel11getInstanceEv")
  //</editor-fold>
  public /*uint*/int getInstance() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// incInstance - Increment the current instance of this Directional Local
  /// Label.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLabel::incInstance">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", old_line = 43,
   FQN = "llvm::MCLabel::incInstance", NM = "_ZN4llvm7MCLabel11incInstanceEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZN4llvm7MCLabel11incInstanceEv")
  //</editor-fold>
  public /*uint*/int incInstance() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// print - Print the value to the stream \p OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLabel::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp", line = 15,
   FQN = "llvm::MCLabel::print", NM = "_ZNK4llvm7MCLabel5printERNS_11raw_ostreamE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZNK4llvm7MCLabel5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// dump - Print the value to stderr.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLabel::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp", line = 20,
   FQN = "llvm::MCLabel::dump", NM = "_ZNK4llvm7MCLabel4dumpEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZNK4llvm7MCLabel4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

}
