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

package org.llvm.cl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.support.impl.CommandLineStatics.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


//--------------------------------------------------
// basic_parser - Super class of parsers to provide boilerplate code
//
//<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 778,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 715,
 FQN="llvm::cl::basic_parser_impl", NM="_ZN4llvm2cl17basic_parser_implE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl17basic_parser_implE")
//</editor-fold>
public class basic_parser_impl implements Destructors.ClassWithDestructor {
// non-template implementation of basic_parser<t>
/*public:*/
  // non-template implementation of basic_parser<t>
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::~basic_parser_impl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 695,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::basic_parser_impl::~basic_parser_impl",
   notes = Converted.Notes.FAILED)
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::getValueExpectedFlagDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 783,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 720,
   FQN="llvm::cl::basic_parser_impl::getValueExpectedFlagDefault", NM="_ZNK4llvm2cl17basic_parser_impl27getValueExpectedFlagDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl17basic_parser_impl27getValueExpectedFlagDefaultEv")
  //</editor-fold>
  public ValueExpected getValueExpectedFlagDefault() /*const*/ {
    return ValueExpected.ValueRequired;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::getExtraOptionNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 787,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 724,
   FQN="llvm::cl::basic_parser_impl::getExtraOptionNames", NM="_ZN4llvm2cl17basic_parser_impl19getExtraOptionNamesERNS_15SmallVectorImplINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl17basic_parser_impl19getExtraOptionNamesERNS_15SmallVectorImplINS_9StringRefEEE")
  //</editor-fold>
  public void getExtraOptionNames(final SmallVectorImpl<StringRef> /*&*/ $Prm0) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::initialize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 789,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 726,
   FQN="llvm::cl::basic_parser_impl::initialize", NM="_ZN4llvm2cl17basic_parser_impl10initializeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl17basic_parser_impl10initializeEv")
  //</editor-fold>
  public void initialize(final Option /*&*/ $Prm0) {
  }

  
  // Return the width of the option tag for printing...
  
  //===----------------------------------------------------------------------===//
  // Parser Implementation code...
  //
  
  // basic_parser implementation
  //
  
// Return the width of the option tag for printing...
//<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::getOptionWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1407,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1180,
   FQN="llvm::cl::basic_parser_impl::getOptionWidth", NM="_ZNK4llvm2cl17basic_parser_impl14getOptionWidthERKNS0_6OptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl17basic_parser_impl14getOptionWidthERKNS0_6OptionE")
//</editor-fold>
  public /*size_t*/int getOptionWidth(final /*const*/ Option /*&*/ O) /*const*/ {
    /*size_t*/int Len = O.ArgStr.size();
    {
      /*const*/char$ptr/*char P*/ ValName = $tryClone(getValueName());
      if (Native.$bool(ValName)) {
        Len += getValueStr(O, new StringRef(ValName)).size() + 3;
      }
    }
    
    return Len + 6;
  }

  
  // printOptionInfo - Print out information about this option.  The
  // to-be-maintained width is specified.
  //
  
  // printOptionInfo - Print out information about this option.  The
  // to-be-maintained width is specified.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::printOptionInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1119,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::basic_parser_impl::printOptionInfo")
  //</editor-fold>
  public void printOptionInfo(/*const*/ Option /*&*/ O,
                 /*size_t*/int GlobalWidth) /*const*/ {
    outs().$out("  -").$out(O.ArgStr);
    {

      /*const*/char$ptr/*char P*/ ValName = $tryClone(getValueName());
      if ((ValName != null)) {
        outs().$out("=<").$out(getValueStr(O, new StringRef(ValName))).$out_char($$GT);
      }
    }

    printHelpStr(new StringRef(O.HelpStr), GlobalWidth, getOptionWidth(O));
  }
  
  // printOptionNoValue - Print a placeholder for options that don't yet support
  // printOptionDiff().
  
  // Print a placeholder for options that don't yet support printOptionDiff().
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::printOptionNoValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1365,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::basic_parser_impl::printOptionNoValue")
  //</editor-fold>
  public void printOptionNoValue(/*const*/ Option /*&*/ O, /*size_t*/int GlobalWidth) /*const*/ {
    printOptionName(O, GlobalWidth);
    outs().$out("= *cannot print option value*\n");
  }

  
  // getValueName - Overload in subclass to provide a better default value.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::getValueName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 718,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::basic_parser_impl::getValueName")
  //</editor-fold>
  public /*virtual*/ /*const*/char$ptr/*char P*/ getValueName() /*const*/ {
    return $("value");
  }

  
  // An out-of-line virtual method to provide a 'home' for this class.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::anchor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 68,
   FQN = "llvm::cl::GenericOptionValue::anchor", NM = "_ZN4llvm2cl18GenericOptionValue6anchorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl18GenericOptionValue6anchorEv")
  //</editor-fold>
  public void anchor() {
  }

/*protected:*/
  // A helper for basic_parser::printOptionDiff.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::printOptionName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1129,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::basic_parser_impl::printOptionName")
  //</editor-fold>
  protected void printOptionName(/*const*/ Option /*&*/ O,
                 /*size_t*/int GlobalWidth) /*const*/ {
    outs().$out("  -").$out(O.ArgStr);
    outs().indent(GlobalWidth - O.ArgStr.size());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::basic_parser_impl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 693,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::basic_parser_impl::basic_parser_impl",
   notes = Converted.Notes.FAILED)
  //</editor-fold>
  public /*inline*/ basic_parser_impl()/* throw()*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::basic_parser_impl::basic_parser_impl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 693,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::basic_parser_impl::basic_parser_impl",
   notes = Converted.Notes.FAILED)
  //</editor-fold>
  public /*inline*/ basic_parser_impl(/*const*/ basic_parser_impl /*&*/ $Prm0)/* throw()*/ {
  }
}
