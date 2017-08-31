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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.cl.*;
import org.llvm.pass.*;


//===----------------------------------------------------------------------===//
// PassNameParser class - Make use of the pass registration mechanism to
// automatically add a command line argument to opt for each pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassNameParser.h", line = 42,
 FQN="llvm::PassNameParser", NM="_ZN4llvm14PassNameParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14PassNameParserE")
//</editor-fold>
public class PassNameParser extends /*public*/ parser</*const*/ PassInfo /*P*/ > implements /*public*/ PassRegistrationListener, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser::PassNameParser">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 239,
   FQN="llvm::PassNameParser::PassNameParser", NM="_ZN4llvm14PassNameParserC1ERNS_2cl6OptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14PassNameParserC1ERNS_2cl6OptionE")
  //</editor-fold>
  public PassNameParser(final Option /*&*/ O) {
    // : PassRegistrationListener(), parser<const PassInfo * >(O) 
    //START JInit
    super(O);
    $PassRegistrationListener();
    //END JInit
    PassRegistry.getPassRegistry().addRegistrationListener(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser::~PassNameParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 244,
   FQN="llvm::PassNameParser::~PassNameParser", NM="_ZN4llvm14PassNameParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14PassNameParserD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    // This only gets called during static destruction, in which case the
    // PassRegistry will have already been destroyed by llvm_shutdown().  So
    // attempting to remove the registration listener is an error.
    PassRegistrationListener.super.$destroy$PassRegistrationListener();
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser::initialize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassNameParser.h", line = 48,
   FQN="llvm::PassNameParser::initialize", NM="_ZN4llvm14PassNameParser10initializeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14PassNameParser10initializeEv")
  //</editor-fold>
  public void initialize(final Option /*&*/ $Prm0) {
    super.initialize($Prm0);
    
    // Add all of the passes to the map that got initialized before 'this' did.
    enumeratePasses();
  }

  
  // ignorablePassImpl - Can be overriden in subclasses to refine the list of
  // which passes we want to include.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser::ignorablePassImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassNameParser.h", line = 58,
   FQN="llvm::PassNameParser::ignorablePassImpl", NM="_ZNK4llvm14PassNameParser17ignorablePassImplEPKNS_8PassInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm14PassNameParser17ignorablePassImplEPKNS_8PassInfoE")
  //</editor-fold>
  public /*virtual*/ boolean ignorablePassImpl(/*const*/ PassInfo /*P*/ P) /*const*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser::ignorablePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassNameParser.h", line = 60,
   FQN="llvm::PassNameParser::ignorablePass", NM="_ZNK4llvm14PassNameParser13ignorablePassEPKNS_8PassInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm14PassNameParser13ignorablePassEPKNS_8PassInfoE")
  //</editor-fold>
  public /*inline*/ boolean ignorablePass(/*const*/ PassInfo /*P*/ P) /*const*/ {
    // Ignore non-selectable and non-constructible passes!  Ignore
    // non-optimizations.
    return $eq_ptr(P.getPassArgument(), null) || P.getPassArgument().$star() == 0
       || $eq_ptr(P.getNormalCtor(), null) || ignorablePassImpl(P);
  }

  
  // Implement the PassRegistrationListener callbacks used to populate our map
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser::passRegistered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassNameParser.h", line = 69,
   FQN="llvm::PassNameParser::passRegistered", NM="_ZN4llvm14PassNameParser14passRegisteredEPKNS_8PassInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14PassNameParser14passRegisteredEPKNS_8PassInfoE")
  //</editor-fold>
  @Override public void passRegistered(/*const*/ PassInfo /*P*/ P)/* override*/ {
    if (ignorablePass(P)) {
      return;
    }
    if (findOption(P.getPassArgument()) != getNumOptions()) {
      errs().$out(/*KEEP_STR*/"Two passes with the same argument (-").$out(
          P.getPassArgument()
      ).$out(/*KEEP_STR*/") attempted to be registered!\n");
      throw new llvm_unreachable(null);
    }
    addLiteralOption(P.getPassArgument(), P, P.getPassName());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser::passEnumerate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassNameParser.h", line = 78,
   FQN="llvm::PassNameParser::passEnumerate", NM="_ZN4llvm14PassNameParser13passEnumerateEPKNS_8PassInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14PassNameParser13passEnumerateEPKNS_8PassInfoE")
  //</editor-fold>
  @Override public void passEnumerate(/*const*/ PassInfo /*P*/ P)/* override*/ {
    passRegistered(P);
  }

  
  // printOptionInfo - Print out information about this option.  Override the
  // default implementation to sort the table before we print...
  //<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser::printOptionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassNameParser.h", line = 82,
   FQN="llvm::PassNameParser::printOptionInfo", NM="_ZNK4llvm14PassNameParser15printOptionInfoERKNS_2cl6OptionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm14PassNameParser15printOptionInfoERKNS_2cl6OptionEj")
  //</editor-fold>
  @Override public void printOptionInfo(final /*const*/ Option /*&*/ O, /*size_t*/int GlobalWidth) /*const*//* override*/ {
    PassNameParser /*P*/ PNP = ((/*const_cast*/PassNameParser /*P*/ )(this));
    array_pod_sort(PNP.Values.begin(), PNP.Values.end(), /*FuncRef*/PassNameParser::ValLessThan);
    super.printOptionInfo(O, GlobalWidth);
  }

/*private:*/
  // ValLessThan - Provide a sorting comparator for Values elements...
  //<editor-fold defaultstate="collapsed" desc="llvm::PassNameParser::ValLessThan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassNameParser.h", line = 90,
   FQN="llvm::PassNameParser::ValLessThan", NM="_ZN4llvm14PassNameParser11ValLessThanEPKNS_2cl6parserIPKNS_8PassInfoEE10OptionInfoES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14PassNameParser11ValLessThanEPKNS_2cl6parserIPKNS_8PassInfoEE10OptionInfoES9_")
  //</editor-fold>
  private static int ValLessThan(/*const*/ PassNameParser.OptionInfo /*P*/ VT1, 
             /*const*/ PassNameParser.OptionInfo /*P*/ VT2) {
    return std.strcmp(VT1.Name, VT2.Name);
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
