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

package org.llvm.option;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.option.*;


/// OptSpecifier - Wrapper class for abstracting references to option IDs.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 20,
 FQN="llvm::opt::OptSpecifier", NM="_ZN4llvm3opt12OptSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt12OptSpecifierE")
//</editor-fold>
public class OptSpecifier implements Native.NativeComparable<OptSpecifier> {
  private /*uint*/int ID;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::OptSpecifier">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 24,
   FQN="llvm::opt::OptSpecifier::OptSpecifier", NM="_ZN4llvm3opt12OptSpecifierC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt12OptSpecifierC1Eb")
  //</editor-fold>
  private /*explicit*/ OptSpecifier(boolean $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::OptSpecifier">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 27,
   FQN="llvm::opt::OptSpecifier::OptSpecifier", NM="_ZN4llvm3opt12OptSpecifierC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt12OptSpecifierC1Ev")
  //</editor-fold>
  public OptSpecifier() {
    /* : ID(0)*/ 
    //START JInit
    this.ID = 0;
    //END JInit
  }

  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::OptSpecifier">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 28,
   FQN="llvm::opt::OptSpecifier::OptSpecifier", NM="_ZN4llvm3opt12OptSpecifierC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt12OptSpecifierC1Ej")
  //</editor-fold>
  public OptSpecifier(/*uint*/int ID) {
    /* : ID(ID)*/ 
    //START JInit
    this.ID = ID;
    //END JInit
  }

  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::OptSpecifier">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 85,
   FQN="llvm::opt::OptSpecifier::OptSpecifier", NM="_ZN4llvm3opt12OptSpecifierC1EPKNS0_6OptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt12OptSpecifierC1EPKNS0_6OptionE")
  //</editor-fold>
  public OptSpecifier(/*const*/ Option /*P*/ Opt) {
    /* : ID(Opt->getID())*/ 
    //START JInit
    this.ID = Opt.getID();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::isValid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 31,
   FQN="llvm::opt::OptSpecifier::isValid", NM="_ZNK4llvm3opt12OptSpecifier7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt12OptSpecifier7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return ID != 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::getID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 33,
   FQN="llvm::opt::OptSpecifier::getID", NM="_ZNK4llvm3opt12OptSpecifier5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt12OptSpecifier5getIDEv")
  //</editor-fold>
  public /*uint*/int getID() /*const*/ {
    return ID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 35,
   FQN="llvm::opt::OptSpecifier::operator==", NM="_ZNK4llvm3opt12OptSpecifiereqES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt12OptSpecifiereqES1_")
  //</editor-fold>
  public boolean $eq(OptSpecifier Opt) /*const*/ {
    return ID == Opt.getID();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 36,
   FQN="llvm::opt::OptSpecifier::operator!=", NM="_ZNK4llvm3opt12OptSpecifierneES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZNK4llvm3opt12OptSpecifierneES1_")
  //</editor-fold>
  public boolean $noteq(OptSpecifier Opt) /*const*/ {
    return !(/*Deref*/this.$eq(/*NO_COPY*/Opt));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::OptSpecifier">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 20,
   FQN="llvm::opt::OptSpecifier::OptSpecifier", NM="_ZN4llvm3opt12OptSpecifierC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt12OptSpecifierC1ERKS1_")
  //</editor-fold>
  public /*inline*/ OptSpecifier(/*const*/ OptSpecifier /*&*/ $Prm0) {
    /* : ID(.ID)*/ 
    //START JInit
    this.ID = $Prm0.ID;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::OptSpecifier::OptSpecifier">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/OptSpecifier.h", line = 20,
   FQN="llvm::opt::OptSpecifier::OptSpecifier", NM="_ZN4llvm3opt12OptSpecifierC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3opt12OptSpecifierC1EOS1_")
  //</editor-fold>
  public /*inline*/ OptSpecifier(JD$Move _dparam, OptSpecifier /*&&*/$Prm0) {
    /* : ID(static_cast<OptSpecifier &&>().ID)*/ 
    //START JInit
    this.ID = $Prm0.ID;
    //END JInit
  }

  
  public String toString() {
    return "" + "ID=" + ID; // NOI18N
  }
}
