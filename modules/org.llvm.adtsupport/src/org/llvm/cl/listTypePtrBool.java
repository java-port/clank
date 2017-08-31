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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


//===----------------------------------------------------------------------===//
// list - A list of command line options.
//
/*template <class int, class boolean = bool, class parserString = parser<int>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::list">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1423,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1360,
 FQN="llvm::cl::list", NM="_ZN4llvm2cl4listE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl4listE")
//</editor-fold>
public class listTypePtrBool<T /*P*/> extends /*public*/ Option implements /*public*/ list_storageTypePtrBool<T>, Iterable<T /*P*/>, Destructors.ClassWithDestructor {
  private final std.vectorUInt/*uint*/ Positions = new vectorUInt();
  private final parser</*const*/ T /*P*/ >  Parser;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::getValueExpectedFlagDefault">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1429,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1366,
   FQN="llvm::cl::list::getValueExpectedFlagDefault", NM="_ZNK4llvm2cl4list27getValueExpectedFlagDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl4list27getValueExpectedFlagDefaultEv")
  //</editor-fold>
  @Override protected/*private*/ ValueExpected getValueExpectedFlagDefault() /*const*//* override*/ {
    return Parser.getValueExpectedFlagDefault();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::getExtraOptionNames">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1432,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1369,
   FQN="llvm::cl::list::getExtraOptionNames", NM="_ZN4llvm2cl4list19getExtraOptionNamesERNS_15SmallVectorImplINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl4list19getExtraOptionNamesERNS_15SmallVectorImplINS_9StringRefEEE")
  //</editor-fold>
  @Override public/*private*/ void getExtraOptionNames(final SmallVectorImpl<StringRef> /*&*/ OptionNames)/* override*/ {
    Parser.getExtraOptionNames(OptionNames);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::handleOccurrence">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1373,
   FQN="llvm::cl::list::handleOccurrence", NM="_ZN4llvm2cl4list16handleOccurrenceEjNS_9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl4list16handleOccurrenceEjNS_9StringRefES2_")
  //</editor-fold>
  @Override protected/*private*/ boolean handleOccurrence(/*uint*/int pos, StringRef ArgName, 
                  StringRef Arg)/* override*/ {
    type$ref<T> Val =  create_type$ref();
    if (Parser.parse(/*Deref*/this, ArgName, Arg, Val)) {
      return true; // Parse Error!
    }
    addValue(Val.$deref());
    setPosition(pos);
    Positions.push_back(pos);
    return false;
  }

  
  // Forward printing stuff to the parser...
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::getOptionWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1449,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1386,
   FQN="llvm::cl::list::getOptionWidth", NM="_ZNK4llvm2cl4list14getOptionWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl4list14getOptionWidthEv")
  //</editor-fold>
  @Override public/*private*/ /*size_t*/int getOptionWidth() /*const*//* override*/ {
    return Parser.getOptionWidth(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::printOptionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1452,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1389,
   FQN="llvm::cl::list::printOptionInfo", NM="_ZNK4llvm2cl4list15printOptionInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl4list15printOptionInfoEj")
  //</editor-fold>
  @Override public/*private*/ void printOptionInfo(/*size_t*/int GlobalWidth) /*const*//* override*/ {
    Parser.printOptionInfo(/*Deref*/this, GlobalWidth);
  }

  
  // Unimplemented: list options don't currently store their default value.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::printOptionValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1457,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1394,
   FQN="llvm::cl::list::printOptionValue", NM="_ZNK4llvm2cl4list16printOptionValueEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl4list16printOptionValueEjb")
  //</editor-fold>
  @Override public/*private*/ void printOptionValue(/*size_t*/int $Prm0/*GlobalWidth*/, boolean $Prm1/*Force*/) /*const*//* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::done">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1460,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1397,
   FQN="llvm::cl::list::done", NM="_ZN4llvm2cl4list4doneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl4list4doneEv")
  //</editor-fold>
  private void done() {
    addArgument();
    Parser.initialize(this);
  }

  
  // Command line options should not be copyable
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::list<DataType, StorageClass, ParserClass>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1466,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1403,
   FQN="llvm::cl::list::list<DataType, StorageClass, ParserClass>", NM="_ZN4llvm2cl4listC1ERKNS0_4listIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl4listC1ERKNS0_4listIT_T0_T1_EE")
  //</editor-fold>
  protected/*private*/ listTypePtrBool(final /*const*/ listTypePtrBool /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1467,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1404,
   FQN="llvm::cl::list::operator=", NM="_ZN4llvm2cl4listaSERKNS0_4listIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl4listaSERKNS0_4listIT_T0_T1_EE")
  //</editor-fold>
  protected/*private*/ listTypePtrBool /*&*/ $assign(final /*const*/ listTypePtrBool /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::getParser">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1470,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1407,
   FQN="llvm::cl::list::getParser", NM="_ZN4llvm2cl4list9getParserEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl4list9getParserEv")
  //</editor-fold>
  public basic_parser /*&*/ getParser() {
    //somthing wrong in type hierarchy
    //return Parser;
    throw new UnsupportedOperationException("somthing wrong in type hierarchy");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::getPosition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1472,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1409,
   FQN="llvm::cl::list::getPosition", NM="_ZNK4llvm2cl4list11getPositionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl4list11getPositionEj")
  //</editor-fold>
  public /*uint*/int getPosition(/*uint*/int optnum) /*const*/ {
    assert Native.$bool(Native.$less(optnum, this.size())) : "Invalid option index";
  return Positions.$at(optnum);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::setNumAdditionalVals">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1477,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1414,
   FQN="llvm::cl::list::setNumAdditionalVals", NM="_ZN4llvm2cl4list20setNumAdditionalValsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl4list20setNumAdditionalValsEj")
  //</editor-fold>
  public void setNumAdditionalVals(/*uint*/int n) {
    super.setNumAdditionalVals(n);
  }

  
  /*template <class ... Mods> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list::list<int, boolean, parserString>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1480,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1416,
   FQN="llvm::cl::list::list<int, boolean, parserString>", NM="Tpl__ZN4llvm2cl4listC1EDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl4listC1EDpRKT_")
  //</editor-fold>
  public /*explicit*/ listTypePtrBool(parserConstructor<T/*P*/> parser, /*const*/ Object /*&*/ ... Ms) {
    // : Option(ZeroOrMore, NotHidden), Parser(*this) 
    //START JInit
    /*ParenListExpr*/super(NumOccurrencesFlag.ZeroOrMore, OptionHidden.NotHidden);
    this.Parser = parser.$newInstance(this);
    //END JInit
    super.apply(this, Ms);
    done();
  }
  
  private $Fields $fields = new $Fields();
  @Override
  public $Fields $list_storage$Fields() {
    return $fields;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void reset() {
    this.Positions.clear();
    list_storage$reset();
    super.reset();
  }

  @Override
  public Iterator<T> iterator() {
    return new JavaIterator<>(begin(), end());
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
    
  @Override public String toString() {
    return "" + "Positions=" + Positions // NOI18N
              + ", Parser=" + NativeTrace.getIdentityStr(Parser) // NOI18N
              + super.toString(); // NOI18N
  }
}
